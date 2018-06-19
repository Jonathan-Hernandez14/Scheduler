package sample;

import javafx.fxml.FXML;
import java.io.*;
import java.util.ArrayList;

// class that controls what the UI does when interacted with
public class Controller {

    @FXML
    public void printSomething() {
        System.out.println("Beginning combinations");
        ArrayList combinations = combine(4, 2);
        System.out.println(combinations);
    }

    @FXML
    public void readList() throws IOException {
        int numLines = 0;
        //Todo: Remember to change the Path name
        File file = new File("C:\\Users\\Jonathan\\Documents\\PROJ\\Scheduler\\src\\sample\\People Lists\\Friday1-3.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        ArrayList<String> people = new ArrayList<String>();
        String line;
        while ((line = buffer.readLine()) != null) {
            System.out.println(line);
            people.add(line);
            numLines++;
        }

        System.out.println(numLines);
        ArrayList peopleComb = combine2(people, 2);
        System.out.println(peopleComb);

    }



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
     * @param list
     * @param k
     * @return
     */
    public ArrayList<ArrayList<String>> combine2(ArrayList<String> list, int k) {

        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        if (list.size() <= 0 || list.size() < k)
            return result;

        ArrayList<String> item = new ArrayList<String>();

        dfs2(list, k, 0, item, result); // because it need to begin from 1

        return result;
    }

    private void dfs2(ArrayList<String> list, int k, int start, ArrayList<String> item, ArrayList<ArrayList<String>> res) {

        //Once result element has two names in it then it is added to the
        if (item.size() == k) {
            res.add(new ArrayList<String>(item));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            item.add(list.get(i));
            dfs2(list, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }

}
