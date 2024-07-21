package graph;

import java.util.*;

public class Equation {
    static void dfs(List<List<String>> queries) {
        for (int i = 0; i < queries.size(); i++) {
            String input = queries.get(i).get(0);
            String output = queries.get(i).get(1);
            if (Objects.equals(input, output) && adjMap.get(input) != null) {
                ans[i] = 1.0;
                continue;
            }
            if (adjMap.get(input) != null && adjMap.get(output) != null) {
                List<Node> outputNode = adjMap.get(input);
                HashSet<String> set = new HashSet<>();
                double res = dfsUtils(outputNode, output, 1.0, set);
                ans[i] = res;
            }else{
                ans[i] = -1;
            }
        }
    }

    private static double dfsUtils(List<Node> outputNode, String output, Double res, HashSet<String> set) {
        for (Node node : outputNode) {
            if (!set.contains(node.v)) {
                set.add(node.v);
                if (Objects.equals(node.v, output)) {
                    return res * node.weight;
                }
                double res1 = dfsUtils(adjMap.get(node.v), output, res * node.weight, set);
                if (res1 != -1.0) {
                    return res1;
                }
            }
        }
        return -1.0;
    }

    static class Node {
        String v;
        double weight;

        Node(String v, double weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    static HashMap<String, List<Node>> adjMap = new HashMap();
    static double[] ans;

    public static double[] calcEquation(List<List<String>> equations, List<Double> values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            List<Node> vertexIn = adjMap.getOrDefault(equations.get(i).get(0), new ArrayList());
            List<Node> vertexOut = adjMap.getOrDefault(equations.get(i).get(1), new ArrayList());
            vertexIn.add(new Node(equations.get(i).get(1), values.get(i)));
            vertexOut.add(new Node(equations.get(i).get(0), 1 / values.get(i)));
            adjMap.put(equations.get(i).get(0), vertexIn);
            adjMap.put(equations.get(i).get(1), vertexOut);
        }
        ans = new double[queries.size()];
        dfs(queries);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrStr1 = sc.nextLine().split(" ");
        List<List<String>> equations = new ArrayList<>();
        List<Double> values = new ArrayList<>();
        List<List<String>> queries = new ArrayList<>();
        int n = Integer.parseInt(arrStr1[0]);
        int m = Integer.parseInt(arrStr1[1]);
        for (int i = 0; i < n; i++) {
            String[] arrStr = sc.nextLine().split(" ");
            List<String> arrList = new ArrayList<>();
            arrList.add(arrStr[0]);
            arrList.add(arrStr[1]);
            equations.add(arrList);
        }
        for (int i = 0; i < n; i++) {
            String[] arrStr = sc.nextLine().split(" ");
            values.add(Double.valueOf(arrStr[0]));
        }
        for (int i = 0; i < m; i++) {
            String[] arrStr = sc.nextLine().split(" ");
            List<String> arrList = new ArrayList<>();
            arrList.add(arrStr[0]);
            arrList.add(arrStr[1]);
            queries.add(arrList);
        }
        double[] res = calcEquation(equations, values, queries);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
