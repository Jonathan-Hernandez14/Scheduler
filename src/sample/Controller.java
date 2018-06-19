package sample;

import javafx.fxml.FXML;

import java.util.ArrayList;

// class that controls what the UI does when interacted with
public class Controller {

    @FXML
    public void printSomething() {
        System.out.println("button pressed");
        ArrayList combinations = combine(4, 2);
        System.out.println(combinations);
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

    private void dfs(int n, int k, int start, ArrayList<Integer> item,
                     ArrayList<ArrayList<Integer>> res) {
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



}
