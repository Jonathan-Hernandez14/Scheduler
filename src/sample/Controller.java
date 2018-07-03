package sample;

import javafx.fxml.FXML;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


// class that controls what the UI does when interacted with
public class Controller {

    //Test file names for files
    private ArrayList<String> txtFileNames = new ArrayList<>();

    private LinkedList<LinkedList<ArrayList<String>>> combinationLists = new LinkedList<>();

    @FXML
    public void printSomething() {
        System.out.println("Beginning combinations");
        ArrayList combinations = combine(4, 2);
        System.out.println(combinations);
    }

    @FXML
    public void readList() throws IOException {

        txtFileNames.add("Friday1-3.txt");

//        txtFileNames.add("B-Saturday10-12.txt");
//        txtFileNames.add("B-Saturday12-2.txt");
//        txtFileNames.add("B-Saturday2-4.txt");
//        txtFileNames.add("B-Sunday9-11.txt");
//
//        txtFileNames.add("Friday1-3.txt");
//        txtFileNames.add("S-Saturday10-12.txt");
//        txtFileNames.add("S-Saturday12-2.txt");
//        txtFileNames.add("S-Saturday2-4.txt");
//        txtFileNames.add("S-Sunday9-11.txt");


        //Todo: Remember to change the Path name

        for (String toAdd: txtFileNames) {

            //File currFile = new File("E:\\Docs\\3 - project\\Scheduler\\src\\sample\\People Lists\\" + toAdd);
            File currFile = new File("C:\\Users\\Jonathan\\Documents\\PROJ\\Scheduler\\src\\sample\\People Lists\\" + toAdd);

            BufferedReader buffer = new BufferedReader(new FileReader(currFile));
            ArrayList<String> people = new ArrayList<String>();
            String line;
            while ((line = buffer.readLine()) != null) {
                people.add(line);
            }
            combinationLists.add(combine2(people, 2));
        }

        System.out.println("list loaded");
    }

    @FXML
    public void printList() throws FileNotFoundException {

        int num = 0;
        for (LinkedList <ArrayList<String>> currList : combinationLists) {
            PrintWriter output = new PrintWriter("final" + num + ".txt");
            for (ArrayList<String> combo : currList) {
                output.println(combo);
            }
            output.close();
            System.out.println("File printed");
            num++;
        }


    }

    @FXML
    public void genWeek() {
        Random rand = new Random();
        int randNum;
        ArrayList<String> chosenPair;

        for (LinkedList <ArrayList<String>> currList : combinationLists) {
            //get random pair
            randNum = rand.nextInt(currList.size());
            chosenPair = currList.get(randNum);
            System.out.println(chosenPair);
            //delete from this list and the rest the pair that was chosen.

            //Todo: concurrent modification exception. cannot modify while iterating through the list use iterator directly
            for (LinkedList <ArrayList<String>> currList2 : combinationLists) {
                for(ArrayList<String> currCombo : currList2) {
                    if (currCombo.get(0).equals(chosenPair.get(0)) || currCombo.get(0).equals(chosenPair.get(1)) || currCombo.get(1).equals(chosenPair.get(0)) || currCombo.get(1).equals(chosenPair.get(1))) {
                        currList2.remove(currCombo);
                    }
                }
            }
        }


        System.out.println("-------------------");
    }

    //---------------------------------------------------------------------------
    // version of the algo that only deals with numbers

    /**
     * method that makes list of possible combinations of n choose k
     * @param n - how many integers to choose from
     * @param k - number of members in each combination
     * @return - Array list of all possible combinations.
     */
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (n <= 0 || n < k)
            return result;

        ArrayList<Integer> item = new ArrayList<Integer>();
        dfs(n, k, 1, item, result); // because it need to begin from 1

        return result;
    }

    private void dfs(int n, int k, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res) {
        if (item.size() == k) {
            res.add(new ArrayList<Integer>(item));
            return;
        }

        for (int i = start; i <= n; i++) {
            item.add(i);
            dfs(n, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }

    //-------------------------------------------------------------------------------------------------

    /**
     *  Method that uses array list of type string rather than numbers
     * @param list - Array list of the people combinations that
     * @param k
     * @return
     */
    private LinkedList<ArrayList<String>> combine2(ArrayList<String> list, int k) {

        LinkedList<ArrayList<String>> result = new LinkedList<>();

        if (list.size() <= 0 || list.size() < k)
            return result;

        ArrayList<String> item = new ArrayList<>();

        dfs2(list, k, 0, item, result); // because it need to begin from 1

        return result;
    }

    private void dfs2(ArrayList<String> list, int k, int start, ArrayList<String> item, LinkedList<ArrayList<String>> res) {

        //Once result element has two names in it then it is added to the
        if (item.size() == k) {
            res.add(new ArrayList<>(item));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            item.add(list.get(i));
            dfs2(list, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }
}