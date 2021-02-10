//package com.zinka.calllog.kafka.conf;
//
//import javafx.util.Pair;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//
//import javax.management.Query;
//import java.util.*;
//
//@EnableKafka
//@Configuration
//public class ConsumerConfiguration1 {
//
////    @Value("${kafka.bootstrap-servers}")
////    private String bootstrapServers;
////
////    @Value("${kafka.group-id}")
////    private String groupId;
////
////    @Value("${kafka.reset-config}")
////    private String resetConfig;
////
////    @Bean
////    public ConsumerFactory<ConsumerRecord<String,String>, Acknowledgment> consumerFactory() {
////        Map<String, Object> props = new HashMap<>();
////        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
////        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
////        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, resetConfig);
////        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1);
////        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
////        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
////        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
////        return new DefaultKafkaConsumerFactory<>(props);
////    }
////
////    @Bean
////    public ConcurrentKafkaListenerContainerFactory<ConsumerRecord<String,String>, Acknowledgment> kafkaListenerContainerFactory() {
////        ConcurrentKafkaListenerContainerFactory<ConsumerRecord<String,String>, Acknowledgment> factory = new ConcurrentKafkaListenerContainerFactory<>();
////        factory.setConsumerFactory(consumerFactory());
////        factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.AckMode.MANUAL);
////        return factory;
////    }
////
////    class Solution {
////        public int numTilePossibilities(String tiles) {
////            Set<String> strings = new HashSet<>();
////            char[] arr = tiles.toCharArray();
////            int l = tiles.length();
////            for(int i=0;i<l;i++){
////                strings.add(Character.toString(arr[i]));
////                List<Character> add = new ArrayList<>();
////                add.add(arr[i]);
////                int count =1;
////                for(int j=0;j<l;j++){
////                    if(i==j)
////                        continue;
////                    add.add(arr[j]);
////                    permute(add,0,count,strings);
////                    count++;
////                }
////            }
////            System.out.println(strings);
////            return strings.size();
////        }
////        public void permute(List<Character> arr, int l, int r, Set<String> strings){
////            if(l==r){
////                strings.add(String.valueOf(arr));
////                return;
////            }
////            for(int i=l;i<=r;i++){
////                char a = arr.get(i);
////                arr.set(i,arr.get(l));
////                arr.set(l,a);
////                permute(arr, l+1, r, strings);
////                a = arr.get(i);
////                arr.set(i,arr.get(l));
////                arr.set(l,a);
////            }
////
////        }
////            public int getMaximumGold(int[][] grid){
////                int max=0;
////                int rows = grid.length;
////                int cols = grid[0].length;
////                for(int i=0;i<rows;i++){
////                    for(int j=0;j<cols;j++){
////                        Boolean[][] arr = new Boolean[rows][cols];
////                        int sum = backtrack(grid,rows,cols,i,j,0,arr);
////                        if(sum>max)
////                            max=sum;
////                    }
////                }
////                return max;
////
////
////            }
////            public int backtrack(int[][] grid,int rows,int col,int rowindex,int colindex,int sum,Boolean[][] arr){
////                if(rowindex <0 || colindex<0 || rowindex==rows||colindex==col || grid[rowindex][colindex]==0 || (Objects.nonNull(arr[rowindex][colindex]) && arr[rowindex][colindex]))
////                    return sum;
////                arr[rowindex][colindex]=true;
////                int sum1 = backtrack(grid,rows,col,rowindex,colindex+1,sum+grid[rowindex][colindex],arr);
////                int sum2 = backtrack(grid,rows,col,rowindex,colindex-1,sum+grid[rowindex][colindex],arr);
////                int sum3 = backtrack(grid,rows,col,rowindex+1,colindex,sum+grid[rowindex][colindex],arr);
////                int sum4 = backtrack(grid,rows,col,rowindex-1,colindex,sum+grid[rowindex][colindex],arr);
////                arr[rowindex][colindex]=false;
////                return sum1>sum2 ? (sum1>sum3 ? (Math.max(sum1, sum4)) : (Math.max(sum3, sum4))) : (sum2>sum3 ? (Math.max(sum2, sum4)) : (Math.max(sum3, sum4)));
////            }
////        }
////
////    class Solution {
////
////        public int numTilePossibilities(String tiles) {
////            Map<String, Integer> strings = new HashMap<>();
////            char[] arr = tiles.toCharArray();
////            Map<String, Integer> result = new HashMap<>();
////            List<Character> path = new ArrayList<>();
////            int l = tiles.length();
////            subset(arr, 0, l, path, strings, result);
////            return result.size();
////        }
////
////        public void subset(char[] a, int index, int l, List<Character> path, Map<String, Integer> strings, Map<String, Integer> result) {
////            for (int i = index; i < l; i++) {
////                path.add(a[i]);
////                if (!strings.containsKey(path.toString())) {
////                    strings.put(path.toString(), 1);
////                    permute(path, 0, path.size() - 1, result);
////                }
////                subset(a, i + 1, l, path, strings, result);
////                path.remove(path.size() - 1);
////            }
////        }
////
////        public void permute(List<Character> arr, int l, int r, Map<String, Integer> strings) {
////            if (l == r) {
////                strings.put(String.valueOf(arr), 1);
////                return;
////            }
////            for (int i = l; i <= r; i++) {
////                char a = arr.get(i);
////                arr.set(i, arr.get(l));
////                arr.set(l, a);
////                permute(arr, l + 1, r, strings);
////                a = arr.get(i);
////                arr.set(i, arr.get(l));
////                arr.set(l, a);
////            }
////
////        }
////
////        public List<List<Integer>> combine(int n, int k) {
////            List<List<Integer>> result = new ArrayList<>();
////            List<Integer> a = new ArrayList<>();
////            for (int i = 1; i <= n; i++)
////                a.add(i);
////            permute(a, 0, n, k, new ArrayList<>(), result);
////            return result;
////        }
////
////        public void permute(List<Integer> integers, int index, int length, int k, List<Integer> path, List<List<Integer>> result) {
////            if (path.size() == k) {
////                result.add(new ArrayList<>(path));
////                return;
////            }
////            for (int i = index; i < length; i++) {
////                path.add(integers.get(i));
////                permute(integers, i + 1, length, k, path, result);
////                path.remove(path.size() - 1);
////            }
////        }
////
////        public List<Integer> sequentialDigits(int low, int high) {
////            List<Integer> integers = new ArrayList<>();
////            int l = String.valueOf(high).length();
////            int v = String.valueOf(low).length();
////            List<Integer> integerList = new ArrayList<>();
////            for (int i = 1; i <= 9; i++)
////                integerList.add(i);
////            for (int i = v; i <= l; i++) {
////                for (int j = 0; j < 9; j++) {
////                    permute(integerList, j, 9, i, 0, integers, high, low);
////                    System.out.println(integers);
////                }
////            }
////            return integers;
////
////        }
////
////        public int permute(List<Integer> integers, int index, int length, int size, int sum, List<Integer> result, int high, int low) {
////            if (sum > high) return sum;
////            if (String.valueOf(sum).length() == size) {
////                if (sum >= low) result.add(sum);
////                return sum;
////            }
////
////
////            for (int i = index; i < length; i++) {
////                sum = sum * 10 + integers.get(i);
////                int sum1 = permute(integers, i + 1, length, size, sum, result, high, low);
////                if (sum1 > high) return sum1;
////                if (sum1 == sum) {
////                    return sum1 / 10;
////                } else {
////                    sum = 0;
////                }
////            }
////            return sum;
////        }
////
////        public List<String> letterCombinations(String digits) {
////            List<String> result = new ArrayList<>();
////            if (digits.length() == 0) {
////                return result;
////            }
////            Map<Integer, List<Character>> digitMap = new HashMap<>();
////            digitMap.put(2, new ArrayList<>(Arrays.asList('a', 'b', 'c')));
////            digitMap.put(3, new ArrayList<>(Arrays.asList('d', 'e', 'f')));
////            digitMap.put(4, new ArrayList<>(Arrays.asList('g', 'h', 'i')));
////            digitMap.put(5, new ArrayList<>(Arrays.asList('j', 'k', 'l')));
////            digitMap.put(6, new ArrayList<>(Arrays.asList('m', 'n', 'o')));
////            digitMap.put(7, new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
////            digitMap.put(8, new ArrayList<>(Arrays.asList('t', 'u', 'v')));
////            digitMap.put(9, new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
////            char[] a = new char[26];
////            a.toString();
////
////            List<Integer> arr = Arrays.stream(digits.split("")).map(x -> Integer.parseInt(x)).collect(Collectors.toList());
////            backtrack(digitMap, 0, (long) digits.length(), result, new ArrayList<>(), arr);
////            return result;
////        }
////
////        public void backtrack(Map<Integer, List<Character>> digitMap, int index, Long length, List<String> result, List<Character> chars, List<Integer> digits) {
////            if (chars.size() == length) {
////                result.add(chars.stream().map(String::valueOf).collect(Collectors.joining()));
////                return;
////            }
////            for (int i = index; i < length; i++) {
////                int l = digitMap.get(digits.get(i)).size();
////                for (int j = 0; j < l; j++) {
////                    chars.add(digitMap.get(digits.get(i)).get(i));
////                    backtrack(digitMap, i + 1, length, result, chars, digits);
////                    chars.remove(chars.size() - 1);
////                }
////
////            }
////        }
////
////        public List<String> restoreIpAddresses(String s) {
////            List<String> result = new ArrayList<>();
////            return result;
////        }
////
////        public List<List<String>> solveNQueens(int n) {
////            List<List<String>> result = new ArrayList<>();
////            List<String> strings = new ArrayList<>();
////            for (int i = 0; i < n; i++) {
////                char[] array = new char[n];
////                Arrays.fill(array, '.');
////                strings.add(new String(array));
////            }
////            backtrack(result, strings, 0, n);
////
////            return result;
////
////        }
////
////        public boolean isSafe(List<String> path, int col, int n, int row) {
////            for (int i = row, j = col - 1; i >= 0 && j >= 0; j--) {
////                if (path.get(i).charAt(j) == 'Q') {
////                    return false;
////                }
////            }
////            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; j--, i--) {
////                if (path.get(i).charAt(j) == 'Q') {
////                    return false;
////                }
////            }
////            for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
////                if (path.get(i).charAt(j) == 'Q') {
////                    return false;
////                }
////            }
////            return true;
////        }
////
////        public void backtrack(List<List<String>> result, List<String> path, int col, int n) {
////            if (col == n) {
////                result.add(new ArrayList<>(path));
////                return;
////            }
////            for (int i = 0; i < n; i++) {
////                StringBuilder s = new StringBuilder(path.get(i));
////                if (isSafe(path, col, n, i)) {
////                    s.setCharAt(col, 'Q');
////                    path.set(i, s.toString());
////                    backtrack(result, path, col + 1, n);
////                }
////                s.setCharAt(col, '.');
////                path.set(i, s.toString());
////            }
////        }
////
////        public int numSquarefulPerms(int[] A) {
////            int l = A.length;
////            Set<List<Integer>> result = new HashSet<>();
////            List<Integer> integers = new ArrayList<>();
////            for (int i = 0; i < l; i++) {
////                integers.add(A[i]);
////            }
////            permute(result, integers, 0, l - 1);
////            return result.size();
////        }
////
////        public boolean square(List<Integer> a, int r) {
////            for (int i = 1; i <= r; i++) {
////                double d = Math.sqrt(a.get(i - 1) + a.get(i));
////                if ((d - Math.floor(d)) != 0)
////                    return false;
////            }
////            return true;
////        }
////
////        public void permute(Set<List<Integer>> path, List<Integer> a, int l, int r) {
////            if (l == r) {
////                if (square(a, r)) {
////                    path.add(a);
////                }
////                return;
////            }
////            for (int i = l; i <= r; i++) {
////                int t = a.get(i);
////                a.set(i, a.get(l));
////                a.set(l, t);
////                permute(path, a, l + 1, r);
////                t = a.get(i);
////                a.set(i, a.get(l));
////                a.set(l, t);
////
////            }
////        }
////
////        class TreeNode {
////            int val;
////            TreeNode left;
////            TreeNode right;
////
////            TreeNode(int x) {
////                val = x;
////            }
////        }
////
////        class Node {
////            public int val;
////            public List<Node> children;
////
////            public Node() {
////            }
////
////            public Node(int _val) {
////                val = _val;
////            }
////
////            public Node(int _val, List<Node> _children) {
////                val = _val;
////                children = _children;
////            }
////        }
////
////        public void preo(TreeNode root, int val) {
////            if (root == null)
////                return;
////            if (root.val < val) {
////                if (root.right == null) {
////                    root.right = new TreeNode(val);
////                    return;
////                }
////                preo(root.right, val);
////                return;
////            }
////            if (root.left == null) {
////                root.left = new TreeNode(val);
////                return;
////            }
////            preo(root.left, val);
////
////        }
////
////        public TreeNode bstFromPreorder(int[] preorder) {
////            int l = preorder.length;
////            if (l == 0)
////                return null;
////            TreeNode root = new TreeNode(preorder[0]);
////            for (int i = 1; i < l; i++) {
////                preo(root, preorder[i]);
////            }
////            return root;
////
////        }
////
////        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
////            List<Integer> integers = new ArrayList<>();
////            pre(root1, root2, integers);
////            Collections.sort(integers);
////            return integers;
////
////        }
////
////        public void pre(TreeNode root1, TreeNode root2, List<Integer> integers) {
////            if (root1 == null && root2 == null)
////                return;
////            if (root1 != null && root2 != null) {
////                integers.add(root1.val);
////                integers.add(root2.val);
////                pre(root1.left, root2.left, integers);
////                pre(root1.right, root2.right, integers);
////                return;
////            }
////            if (root1 != null) {
////                integers.add(root1.val);
////                pre(root1.left, null, integers);
////                pre(root1.right, null, integers);
////                return;
////            }
////            if (root2 != null) {
////                integers.add(root2.val);
////                pre(null, root2.left, integers);
////                pre(null, root2.right, integers);
////            }
////        }
////
////        public TreeNode removeLeafNodes(TreeNode root, int target) {
////            if (root == null)
////                return null;
////
////            removeLeafNodes1(root, root.left, target, true);
////            removeLeafNodes1(root, root.right, target, false);
////            if (root.left == null && root.right == null && root.val == target) {
////                return null;
////            }
////            return root;
////        }
////
////        public void removeLeafNodes1(TreeNode pNode, TreeNode root, int target, boolean isLeft) {
////            if (root == null)
////                return;
////            removeLeafNodes1(root, root.left, target, true);
////            removeLeafNodes1(root, root.right, target, false);
////            if (root.left == null && root.right == null && root.val == target) {
////                if (isLeft) {
////                    pNode.left = null;
////                    return;
////                }
////                pNode.right = null;
////                return;
////            }
////        }
////
////        public List<TreeNode> allPossibleFBT(int n) {
////            if (n % 2 == 0)
////                return new ArrayList<>();
////
////            List<TreeNode> list = new ArrayList<>();
////            TreeNode root = new TreeNode(0);
////            if (n == 1) {
////                list.add(root);
////                return list;
////            }
////            n = n - 3;
////            root.left = new TreeNode(0);
////            root.right = new TreeNode(0);
////            lista(list, n, root, root.left);
////            lista(list, n, root, root.right);
////            return list;
////        }
////
////        public void lista(List<TreeNode> list, int n, TreeNode root, TreeNode parent) {
////            if (n == 0) {
////                list.add(root);
////                return;
////            }
////            n = n - 2;
////            parent.left = new TreeNode(0);
////            parent.right = new TreeNode(0);
////            lista(list, n, root, parent.left);
////            lista(list, n, root, parent.right);
////            parent.left = null;
////            parent.right = null;
////
////        }
////
////        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
////            List<TreeNode> list = new ArrayList<>();
////            int l = to_delete.length;
////            if (l == 0) {
////                list.add(root);
////                return list;
////            }
////            Set<Integer> set = new HashSet<>();
////            for (int i : to_delete)
////                set.add(i);
////
////            return list;
////        }
////
////        public TreeNode constructFromPrePost(int[] pre, int[] post) {
////            int l = pre.length;
////            return constructFromPrePost(pre, post, 0, l - 1, l - 1, 0);
////        }
////
////        public TreeNode constructFromPrePost(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
////            if (preEnd - preStart == -1)
////                return null;
////            TreeNode root = new TreeNode(pre[preStart]);
////            if (preStart - preEnd == 0)
////                return root;
////            int i;
////            for (i = postStart; i >= postEnd; i--) {
////                if (post[i] == pre[preStart + 1])
////                    break;
////            }
////            int l = i;
////            Set<Integer> lpost = new HashSet<>();
////            for (int j = i; j >= postEnd; j--) {
////                lpost.add(post[j]);
////            }
////            for (i = preStart + 1; i <= preEnd; i++) {
////                if (!lpost.contains(pre[i]))
////                    break;
////            }
////            root.left = constructFromPrePost(pre, post, preStart + 1, i - 1, l, postEnd);
////            root.right = constructFromPrePost(pre, post, i, preEnd, postStart - 1, l + 1);
////            return root;
////        }
////
////        public List<List<Integer>> levelOrder(Node root) {
////            List<List<Integer>> list = new ArrayList<>();
////            Map<Integer, List<Integer>> map = new HashMap<>();
////            pre(map, root, 0);
////            for (Map.Entry<Integer, List<Integer>> m : map.entrySet()) {
////                list.add(m.getValue());
////            }
////            return list;
////        }
////
////        public void pre(Map<Integer, List<Integer>> map, Node root, int height) {
////            if (root == null)
////                return;
////            height++;
////            List<Integer> integers;
////            if (map.containsKey(height)) {
////                integers = map.get(height);
////
////            } else {
////                integers = new ArrayList<>();
////            }
////            integers.add(root.val);
////            map.put(height, integers);
////            if (root.children != null) {
////                for (Node n : root.children) {
////                    pre(map, n, height);
////                }
////            }
////        }
////
////        public int maxAncestorDiff(TreeNode root) {
////            if (root == null)
////                return 0;
////            return pre(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
////        }
////
////        public int pre(TreeNode root, int min, int max) {
////            if (root == null)
////                return Integer.MIN_VALUE;
////            min = min < root.val ? min : root.val;
////            max = max > root.val ? max : root.val;
////            int lmax = pre(root.left, min, max);
////            int rmax = pre(root.right, min, max);
////            int nodeMax = Math.max(Math.abs(root.val - min), Math.abs(root.val - max));
////            return Math.max(lmax, Math.max(rmax, nodeMax));
////
////        }
////
////        public int preo(TreeNode root, int height, Map<Integer, List<Integer>> heightMap, Map<Integer, Set<Integer>> parentMap, Map<Integer, TreeNode> treeNodeMap, Set<Integer> parentSet) {
////            if (root == null)
////                return height;
////            height++;
////            treeNodeMap.put(root.val, root);
////            List<Integer> list;
////            if (heightMap.containsKey(height)) {
////                list = heightMap.get(height);
////            } else {
////                list = new ArrayList<>();
////            }
////            list.add(root.val);
////            heightMap.put(height, list);
////            Set<Integer> tempSet = new HashSet<>(parentSet);
////            parentMap.put(root.val, parentSet);
////            tempSet.add(root.val);
////            return Math.max(preo(root.left, height, heightMap, parentMap, treeNodeMap, tempSet), preo(root.right, height, heightMap, parentMap, treeNodeMap, tempSet));
////        }
////
////        public TreeNode lcaDeepestLeaves(TreeNode root) {
////            List<Integer> list = new ArrayList<>();
////            if (root == null)
////                return null;
////            Map<Integer, List<Integer>> heightMap = new HashMap<>();
////            Map<Integer, Set<Integer>> parentMap = new HashMap<>();
////            Map<Integer, TreeNode> treeNodeMap = new HashMap<>();
////            int h = preo(root, 0, heightMap, parentMap, treeNodeMap, new HashSet<>());
////            List<Integer> hei = heightMap.get(h);
////            System.out.println(hei);
////            int size = hei.size();
////            if (size == 1)
////                return treeNodeMap.get(hei.get(0));
////            int lsize = parentMap.get(hei.get(0)).size();
////            int[] arr = new int[lsize];
////            int i = 0;
////            for (Integer integer : parentMap.get(hei.get(0))) {
////                arr[i] = integer;
////                i++;
////            }
////            System.out.println(arr.toString());
////            for (int p = lsize - 1; p >= 0; p--) {
////                i = arr[p];
////                int j = 1;
////
////                for (j = 1; j < size; j++) {
////                    System.out.print(parentMap.get(hei.get(j)));
////                    if (!parentMap.get(hei.get(j)).contains(i))
////                        break;
////                }
////                if (j == size) {
////                    return treeNodeMap.get(i);
////                }
////            }
////            return null;
////        }
////
////        public int[] findFrequentTreeSum(TreeNode root) {
////            Map<Integer, Integer> sumMap = new HashMap<>();
////            pre(root, sumMap, 0);
////            Integer max = -1;
////            for (Map.Entry<Integer, Integer> m : sumMap.entrySet())
////                max = Math.max(max, m.getValue());
////            List<Integer> list = new ArrayList<>();
////            for (Map.Entry<Integer, Integer> m : sumMap.entrySet()) {
////                if (m.getValue() == max) {
////                    list.add(m.getKey());
////                }
////            }
////
////            return list.stream().mapToInt(i -> i).toArray();
////
////        }
////
////        public int pre(TreeNode root, Map<Integer, Integer> sumMap, int sum) {
////            if (root == null)
////                return sum;
////            int sum1 = pre(root.left, sumMap, sum);
////            int sum2 = pre(root.right, sumMap, sum);
////            sum = sum + sum1 + sum2 + root.val;
////            if (sumMap.containsKey(sum)) {
////                sumMap.put(sum, sumMap.get(sum) + 1);
////            } else {
////                sumMap.put(sum, 1);
////            }
////            return sum;
////        }
////
////        public int rob(int[] nums) {
////            int l = nums.length;
////            if (l == 0)
////                return 0;
////            if (l == 1)
////                return nums[0];
////            if (l == 2)
////                return Math.max(nums[0], nums[1]);
////            if (l == 3)
////                return Math.max(nums[2], Math.max(nums[0], nums[1]));
////            int[] max = new int[l];
////            max[0] = nums[0];
////            max[1] = nums[1];
////            max[2] = Math.max(max[1], nums[2]);
////            for (int i = 3; i < l; i++) {
////                max[i] = Math.max(max[i - 2] + nums[i], max[i - 1]);
////            }
////            max[1] = Math.max(nums[1], max[0]);
////            for (int i = 2; i < l - 1; i++) {
////                max[i] = Math.max(max[i - 2] + nums[i], max[i - 1]);
////            }
////            return Math.max(max[l - 1], max[l - 2]);
////        }
////
////        public int rob(TreeNode root) {
////            return 1;
////        }
////
////        public Pair<Integer, Integer> sum(TreeNode root, Pair<Integer, Integer> pair) {
////            if (root == null)
////                return pair;
////            sum(root.left, new Pair<>(pair.getValue(), Math.max(pair.getValue(), pair.getKey() + root.val)));
////            sum(root.right, new Pair<>(pair.getValue(), Math.max(pair.getValue(), pair.getKey() + root.val)));
////            return pair;
////        }
////
////        public int pre(TreeNode root) {
////            if (root == null)
////                return 0;
////            int h1 = pre(root.left);
////            int h2 = pre(root.right);
////            if (h1 == -1 || h2 == -1)
////                return -1;
////            if (h2 > h1)
////                return -1;
////            return h1 + 1;
////
////        }
////
////        public boolean isCompleteTree(TreeNode root) {
////            if (pre(root) == -1)
////                return false;
////            return true;
////        }
////
////        public void pos(TreeNode root, int target, List<List<Integer>> lists, List<Integer> path, int sum) {
////            if (root == null) {
////                return;
////            }
////            sum += root.val;
////            path.add(root.val);
////            if (root.left == null && root.right == null) {
////                if (sum == target) {
////                    lists.add(new ArrayList<>(path));
////                }
////                path.remove(path.size() - 1);
////                return;
////            }
////            pos(root.left, target, lists, path, sum);
////            pos(root.right, target, lists, path, sum);
////            path.remove(path.size() - 1);
////
////        }
////
////        public TreeNode deleteNode(TreeNode root, int key) {
////            List<Integer> list = new ArrayList<>();
////            return root;
////        }
////
////
////        public void po(TreeNode root, List<Integer> integers) {
////            po(root.left, integers);
////            integers.add(root.val);
////            po(root.right, integers);
////        }
////
////        public boolean isValidBST(TreeNode root) {
////            List<Integer> integers = new ArrayList<>();
////            po(root, integers);
////            int s = integers.size();
////            int i = 0;
////            for (i = 0; i < s - 1; i++) {
////                if (integers.get(i) > integers.get(i + 1))
////                    break;
////            }
////            if (i != s - 1)
////                return false;
////            return true;
////        }
////
////        class Trie {
////            Trie[] children = new Trie[26];
////
////            public Trie() {
////                for (int i = 0; i < 26; i++) {
////                    this.children[i] = null;
////                }
////            }
////        }
////
////        public boolean isSubsequence(String s, String t) {
////            Trie tChar = new Trie();
////            Trie temp = tChar;
////            for (char i : t.toCharArray()) {
////                int index = i - 'a';
////                temp.children[index] = new Trie();
////                temp = temp.children[index];
////            }
////            for (char i : s.toCharArray()) {
////                int index = i - 'a';
////                while (true) {
////                    if (tChar == null)
////                        return false;
////                    if (tChar.children[index] != null) {
////                        tChar = tChar.children[index];
////                        break;
////                    } else {
////                        int j;
////                        for (j = 0; j < 26; j++) {
////                            if (tChar.children[j] != null) {
////                                tChar = tChar.children[j];
////                                break;
////                            }
////                        }
////                        if(j==26)
////                            tChar = null;
////                    }
////
////                }
////            }
////            return true;
////        }
////        public int climbStairs(int n) {
////            int[] arr = new int[n];
////            arr[0]=1;
////            arr[1]=2;
////            for(int i=2;i<n;i++){
////                arr[i]=arr[i-1]+arr[i-2];
////            }
////            return arr[n-1];
////        }
////        class NumArray {
////            List<Integer> integers = new ArrayList<>();
////            public NumArray(int[] nums) {
////                int l = nums.length;
////                int sum =0;
////                for(int i=0;i<l;i++){
////                    sum+=nums[i];
////                    integers.add(sum);
////                }
////            }
////
////            public int sumRange(int i, int j) {
////                if(i==0)
////                    return integers.get(j);
////                return integers.get(j)-integers.get(i-1);
////            }
////        }
////        public int countSubstrings(String s) {
////            int count =0;
////            int l = s.length();
////            char[] arr = s.toCharArray();
////            return count;
////
////        }
////        static class TestClass {
////            public static void main(String args[] ) throws Exception {
////
////                //Scanner
////                Scanner s = new Scanner(System.in);
////                int  n  = s.nextInt();
////                int[] arr = new int[n];
////                for(int i=0;i<n;i++){
////                    arr[i] = s.nextInt();
////                }
////                int k = s.nextInt();
////                int x = s.nextInt();
////                System.out.println(arr);
////                System.out.println(n);
////                System.out.println(k+x);
////                int[] cost = new int[n];
////                cost[0]=0;
////
////                for(int i=1;i<=k;i++){
////                    if(arr[i]==arr[0])
////                        cost[i]=0;
////                    else{
////                        cost[i]=x;
////                    }
////                }
////                System.out.println(cost.toString());
////                for(int i=k+1;i<n;i++){
////                    int min =Integer.MAX_VALUE;
////                    for(int j=i-1;Math.abs(j-i)<=k;j--){
////                        if(arr[i]==arr[j]) {
////                            min = cost[j];
////                            break;
////                        }
////                        else{
////                            int c = cost[j]+x;
////                            if(c<min){
////                                min =c;
////                            }
////                        }
////
////                    }
////                    cost[i]=min;
////                }
////                System.out.println(cost[n-1]);
////
////            }
////        }
////        public class Trie1{
////            boolean isLeaf;
////            Trie1[] children;
////            Trie1(){
////                children = new Trie1[26];
////                isLeaf=false;
////                for(int i=0;i<26;i++)
////                    children[i]= null;
////            }
////        }
////        public int longestCommonSubsequence(String text1, String text2) {
////            return 2;
////        }
////
////        public int longestStrChain(String[] words) {
////            List<Boolean> booleans = new ArrayList<>(words.length);
////            Arrays.sort(words);
////
////            List<Integer> integers = new ArrayList<>(words.length);
////            List<Map<Character,Integer>> mapList = new ArrayList<>(words.length);
////            for(String word: words){
////                integers.add(word.length());
////                booleans.add(false);
////                Map<Character,Integer> map = new HashMap<>();
////                for(char i:word.toCharArray()){
////                    if(map.containsKey(i)){
////                        map.put(i,map.get(i)+1);
////                    }
////                    else{
////                        map.put(i,1);
////                    }
////                }
////                mapList.add(map);
////            }
////            int max = 1;
////            int l = words.length;
////            for(int i=0;i<l-1;i++){
////                if(booleans.get(i))
////                    continue;
////                int count =1;
////                for(int j=i+1;j<l;j++){
////                    if(booleans.get(j))
////                        break;
////                    if(integers.get(j-1)+1 == integers.get(j)){
////
////                        count++;
////                        booleans.set(j,true);
////                    }
////
////                }
////                if(count>max)
////                    max=count;
////            }
////            return max;
////        }
////        public int singleNumber(int[] nums) {
////            Map<Integer, Integer> map = new HashMap<>();
////            int l= nums.length;
////            for(int i=0;i<l;i++){
////                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
////            }
////            int k=-1;
////            for(Map.Entry<Integer, Integer> a:map.entrySet()){
////                if(a.getValue() == 1){
////                    k=a.getKey();
////                    break;
////                }
////            }
////            return k;
////        }
////
////        public boolean isHappy(int n) {
////            Set<Integer> integerSet = new HashSet<>();
////            integerSet.add(n);
////            while(true){
////                int s=getSquare(n);
////                n=s;
////                if(s==1)
////                    return true;
////                else{
////                    if(integerSet.contains(s)){
////                        return false;
////                    }
////                    else{
////                        integerSet.add(s);
////                    }
////                }
////            }
////
////        }
////        public int getSquare(int n){
////            int sum =0;
////            while(n!=0){
////                int a =n%10;
////                sum+=a*a;
////                n=n/10;
////            }
////            return sum;
////        }
////        public void moveZeroes(int[] nums) {
////            int l = nums.length;
////            int count =0,i=0;
////            int j=0;
////            for(;i<l;i++){
////                if(nums[i]!=0){
////                    nums[j]=nums[i];
////                    j++;
////                }
////            }
////            for(;j<l;j++){
////                nums[j]=0;
////            }
////        }
////
////
////    }
//
//    class Solution {
//        Set<List<Integer>> ans= new HashSet<>();
//        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
////            Arrays.sort(candidates);
//            backtrack(candidates,target,new ArrayList<>(),0,0);
//
//            return new ArrayList<>(ans);
//        }
//        public void backtrack(int [] candidates,int target,ArrayList<Integer> path,int sum,int index){
//            if(sum>=target){
//                if(sum==target){
//                    ans.add(new ArrayList<>(path));
//                }
//                return;
//            }
//            for(int i=index;i<candidates.length;i++){
////                if(candidates[i]>target)break;
//                path.add(candidates[i]);
//                backtrack(candidates,target,path,sum+candidates[i],i+1);
//                path.remove(path.size()-1);
//            }
//        }
//
//        public int firstMissingPositive(int[] nums) {
//            Set<Integer> map = new HashSet<>();
//            int l=0;
//            for(int i:nums){
////                if(i<=0)continue;
//                l++;
//                map.add(i);
//            }
////            int l=nums.length;
//            for(int i=1;i<=l;i++){
//                if(!map.contains(i))
//                    return i;
//            }
//            return 1;
//        }
//
//        public int numTilePossibilities(String tiles) {
//            char[] chars = tiles.toCharArray();
//            Set<String> strings = new HashSet<>();
//            int l = tiles.length();
//            permute(0,l,chars,strings);
//            Set<String> strings1 = new HashSet<>();
////            System.out.println(strings);
//            System.out.println(strings.size());
//            for(String str: strings){
//                System.out.println(str);
//                subset(0,l-1,str.toCharArray(),strings1,new ArrayList<>(),0);
//            }
//            return strings1.size();
//        }
//        public void subset(int i,int j,char[] chars,Set<String> strings,List<Character> characters,int size){
//            for(int k=i;k<=j;k++){
//                characters.add(chars[k]);
//                System.out.println(chars[k]);
//                size++;
//                strings.add(getStringRepresentation(characters));
//                System.out.println(characters.size());
//                subset(i+1,j,chars,strings,characters,size);
//                characters.remove(characters.size()-1);
//                size--;
//            }
//        }
//
//        String getStringRepresentation(List<Character> list)
//        {
//            StringBuilder builder = new StringBuilder(list.size());
//            for(Character ch: list)
//            {
//                builder.append(ch);
//            }
//            return builder.toString();
//        }
//
//        public void permute(int i,int j, char[] chars,Set<String> strings){
//            if(i==j){
//                strings.add(String.valueOf(chars));
//                return;
//            }
//            for(int k=i;k<j;k++){
//                char t = chars[i];
//                chars[i]= chars[k];
//                chars[k] = t;
//                permute(i+1,j,chars,strings);
//                t = chars[i];
//                chars[i]= chars[k];
//                chars[k] = t;
//            }
//        }
//
//
//        public int numTilePossibilities(String tiles) {
//            Map<String,Integer> strings = new HashMap<>();
//            char[] arr = tiles.toCharArray();
//            Map<String,Integer> result = new HashMap<>();
//            List<Character> path = new ArrayList<>();
//            int l = tiles.length();
//            subset(arr,0,l,path,strings,result);
//            return result.size();
//        }
//        public void subset(char[] a,int index,int l,List<Character> path,Map<String,Integer> strings,Map<String,Integer> result){
//            for(int i=index;i<l;i++){
//                path.add(a[i]);
//                if(!strings.containsKey(path.toString())){
//                    strings.put(path.toString(),1);
//                    permute(path,0,path.size()-1,result);
//                }
//                subset(a,i+1,l,path,strings,result);
//                path.remove(path.size()-1);
//            }
//        }
//        public void permute(List<Character> arr,int l,int r,Map<String,Integer> strings){
//            if(l==r){
//                strings.put(String.valueOf(arr),1);
//                return;
//            }
//            for(int i=l;i<=r;i++){
//                char a = arr.get(i);
//                arr.set(i,arr.get(l));
//                arr.set(l,a);
//                permute(arr, l+1, r, strings);
//                a = arr.get(i);
//                arr.set(i,arr.get(l));
//                arr.set(l,a);
//            }
//
//        }
//
//        public List<List<Integer>> combinationSum(int[] candidates, int target) {
//            int l = candidates.length;
//            Set<List<Integer>> lists = new HashSet<>();
//            subset(0,l,new ArrayList<>(),lists,target,0,candidates,0);
//            return new ArrayList<>(lists);
//        }
//        public void subset(int i,int j,List<Integer> list,Set<List<Integer>> lists,int target,int sum,int[] arr,int size){
//            if(sum>target){
//                return;
//            }else if(sum==target){
//                lists.add(new ArrayList<>(list));
//                return;
//            }
//            for(int k=i;k<=j;k++){
//                list.add(arr[k]);
//                sum+=arr[k];
//                size++;
//                subset(k,j,list,lists,target,sum,arr,size);
//                sum -= arr[k];
//                size--;
//                list.remove(size);
//
//
//            }
//        }
//
//        // public List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//        // }
//        Set<List<Integer>> ans= new HashSet<>();
//        public List<List<Integer>> combinationSum(int[] candidates, int target) {
//            Arrays.sort(candidates);
//            backtrack(candidates,target,new ArrayList<>(),0,0);
//
//            return new ArrayList<>(ans);
//        }
//        public void backtrack(int [] candidates,int target,ArrayList<Integer> path,int sum,int index){
//            if(sum>=target){
//                if(sum==target){
//                    ans.add(new ArrayList<>(path));
//                }
//                return;
//            }
//            for(int i=index;i<candidates.length;i++){
//                if(candidates[i]>target)break;
//                path.add(candidates[i]);
//                backtrack(candidates,target,path,sum+candidates[i],i);
//                path.remove(path.size()-1);
//            }
//        }
//
//
//        class WordDictionary {
//
//            /** Initialize your data structure here. */
//            WordDictionary[] children = new WordDictionary[26];
//            boolean isLeafNode;
//            static Map<String,Boolean> stringBooleanMap = new HashMap<>();
//            public WordDictionary() {
//                for(int i=0;i<26;i++){
//                    this.children[i]=null;
//                }
//                this.isLeafNode = false;
//            }
//
//            /** Adds a word into the data structure. */
//            public void addWord(String word) {
//                WordDictionary wordDictionary = null;
//                int l=word.length();
//                for(int i=0;i<l;i++){
//                    int index=word.charAt(i) - 'a';
//                    if(this.children[index]==null)
//                        this.children[index]= new WordDictionary();
//                    wordDictionary=this.children[index];
//                }
//                wordDictionary.isLeafNode=true;
//
//            }
//
//            /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
//            public boolean search(String word) {
//                boolean present = false;
//                WordDictionary wordDictionary=this;
//                int l=word.length();
//                if(!WordDictionary.stringBooleanMap.containsKey(word))
//                    WordDictionary.stringBooleanMap.put(word,isPresent(this,word,l,0));
//                return WordDictionary.stringBooleanMap.get(word);
//            }
//            public Boolean isPresent(WordDictionary wordDictionary,String word,int l,int index){
//                boolean is=false;
//                for(int i=index;i<l;i++){
//                    if(word.charAt(i)!='.' && wordDictionary.children[word.charAt(i)-'a'] == null){
//                        System.out.println("**********************"+ i+ word.charAt(i));
//                        return false;
//                    }
//                    if(word.charAt(i)=='.'){
//                        for(int j=0;j<26;j++) {
//                            if(wordDictionary.children[j]!=null)
//                                if(isPresent(wordDictionary.children[j], word, l, i + 1)){
//                                    is=true;
//                                    break;
//                                }
//
//                        }
//                        return is;
//                    }
//                    wordDictionary=wordDictionary.children[word.charAt(i)-'a'];
//                }
//                System.out.println("###################");
//                return is || wordDictionary.isLeafNode;
//
//            }
//
//            public String getPermutation(int n, int k) {
//                int sum =0;
//                int[] arr = new int[n];
//                for(int i=1;i<=n;i++){
//                    arr[i-1] = i;
//                }
//                for(int i=1;i<=k;i++){
//                    getNextGreater(arr,n);
//                    System.out.println(Arrays.toString(arr));
//                }
//                return Arrays.toString(arr).replaceAll("\\[|\\]|,|\\s", "");
////                return arr.toString();
//            }
//            public void getNextGreater(int[] arr ,int n){
//                int i;
//                for(i=n-2;i>=0;i++){
//                    if(arr[i+1]>arr[i])
//                        break;
//                }
//                if(i<0)
//                    return;
//                int j=i,k=i;
//                int index = i+1;
//                for(k=i+1;k<n;k++){
//                    if(arr[j]>arr[k])
//                        break;
//                }
//                int t = arr[j];
//                arr[j]= arr[k-1];
//                arr[k-1]=t;
//                int o = n-1;
//                for(int l=j+1;l!=o;l++,o--){
//                    t=arr[l];
//                    arr[l]=arr[0];
//                    arr[o]=t;
//                }
//            }
//
//            public List<List<String>> solveNQueens(int n) {
//                char[][] arr = new char[n][n];
//                for(int k=0;k<n;k++){
//                    for(int l=0;l<n;l++){
//                        arr[k][l] = '.';
//                    }
//                }
//                List<List<String>> lists = new ArrayList<>();
//                backtrack(lists,arr,n,0);
//                return lists;
//            }
//
//            public boolean isSafe(char[][] arr,int i,int j,int n){
//                for(int k=i-1,p=j-1;k>=0&&p>=0;k--,p--){
//                    if(arr[k][p] == 'Q')
//                        return false;
//                }
//                for(int k=i+1,p=j-1;k>=0&&p<n;k++,p--){
//                    if(arr[k][p] == 'Q')
//                        return false;
//                }
//
//                for(int p=j-1;p>=0;p--){
//                    if(arr[i][p] == 'Q')
//                        return false;
//                }
//                return true;
//            }
//            public void backtrack(List<List<String>> lists,char[][] arr,int n,int i){
//                if(i==n){
//                    List<String> strings = new ArrayList<>();
//                    for(int p=0;p<n;p++){
//                        strings.add(String.valueOf(arr[p]));
//                    }
//                    lists.add(strings);
//                    return;
//                }
//                    for(int l=0;l<n;l++){
//                        if(isSafe(arr,l,i,n)){
//                            arr[l][i]= 'Q';
//                            backtrack(lists,arr,n,i+1);
//                            arr[l][i] = '.';
//                        }
//
//                    }
//            }
//
//
//        }
//
//         public class TreeNode {
//              int val;
//              TreeNode left;
//              TreeNode right;
//              TreeNode(int x) { val = x; }
//        }
//        public int sumRootToLeaf(TreeNode root) {
//            return traverse(root,0);
//        }
//        public int traverse(TreeNode root,int sum){
//            if(root == null) {
//                int val =0;
//                int count =0;
//                while (sum!=0){
//                    int a = sum%10;
//                    sum=sum/10;
//                    if(a!=0){
//                        val+=Math.pow(2,count);
//                    }
//                    count++;
//                }
//
//            }
//
//            sum = sum*10+ root.val;
//            if(root.left!=null && root.right!=null)
//                return traverse(root.left,sum) + traverse(root.right,sum);
//
//            if(root.left!=null)
//                return traverse(root.left,sum);
//
//            return traverse(root.right,sum);
//        }
//
//
//        public int sumRootToLeaf1(TreeNode root) {
//            int sum=0;
//            List<Integer> strings = new ArrayList<>();
//
//            return inOrde(root,strings,"",0);
//
//        }
//        public int inOrde(TreeNode root,List<Integer> integers,String path,int sum){
//            if(root == null){
//                sum+= Integer.parseInt(path,2);
//                return sum;
//            }
//            path = path.concat(String.valueOf(root.val));
//            if(root.left!=null && root.right!=null)
//                return inOrde(root.left,integers,path,sum) + inOrde(root.right,integers,path,sum);
//            else if(root.left==null && root.right!=null)
//                return inOrde(root.right,integers,path,sum);
//            else if(root.left != null)
//                return inOrde(root.left,integers,path,sum);
//            else
//                return sum+ Integer.parseInt(path,2);
//
//        }
//
//        public boolean isCousins(TreeNode root, int x, int y) {
//            Map<Integer,Pair<TreeNode,Integer>> depthmap = new HashMap<>();
//            Map<TreeNode,Integer> map = new HashMap<>();
//            map.put(null,0);
//            depthmap.put(root.val,new Pair<>(null,0));
//            traverse1(root,root.left,depthmap,0);
//            traverse1(root,root.right,depthmap,0);
//            if(depthmap.containsKey(x) && depthmap.containsKey(y) &&
//                    depthmap.get(x).getValue().equals(depthmap.get(y).getValue()) &&
//                    depthmap.get(x).getKey().equals(depthmap.get(y).getKey()))
//                return true;
//            return false;
//        }
//
//        public void traverse1(TreeNode pNode,TreeNode root,Map<Integer,Pair<TreeNode,Integer>> depthmap,int depth){
//            if(root == null) {
//              return;
//            }
//
//            depth++;
//            depthmap.put(root.val,new Pair<>(pNode,depth));
//            traverse1(root,root.left,depthmap,depth);
//            traverse1(root,root.right,depthmap,depth);
//        }
//
//        public TreeNode buildTree(int[] preorder, int[] inorder) {
//            int p = preorder.length;
//            int i=inorder.length;
//            if(p==0|| i==0)
//                return null;
//            TreeNode root = new TreeNode(preorder[0]);
//            int k=0;
//            for(;k<i;k++){
//                if(inorder[i] == root.val)
//                    break;
//            }
//            root.left= buildTree(Arrays.copyOfRange(preorder,1,p),Arrays.copyOfRange(inorder,0,k));
//
//            root.right= buildTree(Arrays.copyOfRange(preorder,1,p),Arrays.copyOfRange(inorder,0,k));
//            return root;
//        }
//
//        public boolean isBalanced(TreeNode root) {
//
//        }
//        public Pair<Integer,Boolean> depth(TreeNode root,int depth){
//            if(root==null)
//                return null;
//            depth++;
//            Pair<Integer,Boolean> l = depth(root.left,depth);
//            Pair<Integer,Boolean> r = depth(root.left,depth);
//            if(l!=null && r!=null)
//            {
//                if(Math.abs(l.getKey()-r.getKey()) <= 1)
//                    return new Pair<>(Math.max(l.getKey(),r.getKey()),true);
//                else
//                    return new Pair<>(Math.max(l.getKey(),r.getKey()),false);
//            }
//            if(l!=null){
//                return l;
//            }
//            if(r!=null)
//                return r;
//            return new Pair<>(depth,true);
//        }
//        public boolean isSymmetric(TreeNode root) {
//            if(root==null)
//                return true;
//            return tes(root.left,root.right);
//        }
//
//        public boolean tes(TreeNode left,TreeNode right){
//            if(left==null&&right==null)
//                return true;
//            if(left!=null && right==null)
//                return false;
//            if(left == null)
//                return false;
//            if(left.val!=right.val)
//                return false;
//            return tes(left.left,right.right) && tes(left.right,right.left);
//        }
//
//        public boolean isSymmetric1(TreeNode root) {
//            if(root ==  null)
//                return true;
//            return false;
//
//        }
//        public int pre(TreeNode root, Map<TreeNode,Integer> depthL,int depth){
//            if(root == null)
//                return depth;
//            depthL.put(root,depth);
//            int d1=depth,d2=depth;
//            depth++;
//            if(root.left!=null)
//                d1= pre(root.left,depthL,depth);
//            if(root.right!=null)
//                d2=pre(root.right,depthL,depth);
//            return Math.max(d1,d2);
//        }
//
//
//        public TreeNode lcaDeepestLeaves(TreeNode root) {
//            if(root==null)
//                return null;
//            Map<TreeNode,Integer> treeNodeIntegerMap= new HashMap<>();
//
//            int max= pre(root,treeNodeIntegerMap,0);
//            return re(root,treeNodeIntegerMap,max);
//
//        }
//        public TreeNode re(TreeNode root, Map<TreeNode,Integer> depthL,int depth){
//            if(root==null || depthL.get(root) == depth)
//                return root;
//            TreeNode l = re(root.left,depthL,depth);
//            TreeNode r = re(root.right,depthL,depth);
//            if(l!=null&&r!=null)
//                return root;
//            if(l!=null)
//                return l;
//            return r;
//        }
//
//        public List<List<Integer>> verticalTraversal(TreeNode root) {
//            Map<Integer,List<Integer>> depthmap = new HashMap<>();
//            List<List<Integer>> lists = new ArrayList<>();
//            if(root==null)
//                return lists;
//            traverse2(root,depthmap,0);
//            Set<Integer> integerSet = depthmap.keySet();
//            int min =0,max=0;
//            for(Integer integer:integerSet){
//                if(integer<min)
//                    min=integer;
//                else if(integer>max)
//                    max=integer;
//            }
//            for(int i=min;i>=max;i++){
//                lists.add(depthmap.get(i));
//            }
//            return lists;
//        }
//
//        public void traverse2(TreeNode root,Map<Integer,List<Integer>> depthmap,int depth){
//            if(root == null) {
//                return;
//            }
//            List<Integer> list;
//            if(depthmap.containsKey(depth))
//                list=depthmap.get(depth);
//            else
//                list=new ArrayList<>();
//            list.add(root.val);
//            depthmap.put(depth,list);
//
//            traverse2(root.left,depthmap,depth-1);
//            traverse2(root.right,depthmap,depth+1);
//        }
//
//        public int minCostClimbingStairs(int[] cost) {
//            int steps = cost.length;
//            int[] arr= new int[steps];
//            arr[0]=cost[0];
//            arr[1]=cost[1];
//            if(steps==2)
//                return Math.min(arr[0],arr[1]);
//            for(int i=2;i<steps;i++){
//                if(arr[i-1]<arr[i-2]+cost[i])
//                    arr[i]=arr[i-1];
//                else
//                    arr[i]=arr[i-2]+cost[i];
//            }
//            return arr[steps-1];
//        }
//        int solve(int S,int cnt1,int cnt2,int cnt3,int cost1,int cost2,int cost3) {
//            int[] cnt= {cnt1,cnt2,cnt3};
//            int[] cst= {cost1,cost2,cost3};
//            int[] energy= {2,3,5};
//
//        }
//        void solve(int S,int[] cnt,int[] cst,int[] energy,int sum,int sum1,int cnt1) {
//            if(sum1==S){
//                if(sum1<k)
//                    k=sum1;
//                return;
//            }
//            for(int i=cnt1;i<3;i++){
//
//                for(int j=1;j<=cnt[i];j++) {
//                    sum += cst[i];
//                    sum1 += energy[i];
//                    if(sum1>S)
//                        break;
//                    solve(S,cnt,cst,energy,sum,sum1,i+1);
//                }
//                sum=0;
//                sum1=0;
//            }
//        }
//
//
//        class TestClass {
//            static  int k=Integer.MAX_VALUE;
//            public static void main(String args[] ) throws Exception {
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                int S=Integer.parseInt(br.readLine().trim());
//                int cnt1,cnt2,cnt3,cost1,cost2,cost3;
//                String[] inp1=br.readLine().split(" ");
//                cnt1=Integer.parseInt(inp1[0]);
//                cnt2=Integer.parseInt(inp1[1]);
//                cnt3=Integer.parseInt(inp1[2]);
//
//                String[] inp2=br.readLine().split(" ");
//                cost1=Integer.parseInt(inp2[0]);
//                cost2=Integer.parseInt(inp2[1]);
//                cost3=Integer.parseInt(inp2[2]);
//                int ans=solve(S,cnt1,cnt2,cnt3,cost1,cost2,cost3);
//                System.out.println(ans);
//            }
//            static int solve(int S,int cnt1,int cnt2,int cnt3,int cost1,int cost2,int cost3) {
//                //Your code goes here
//                int[] cnt= {cnt1,cnt2,cnt3};
//                int[] cst= {cost1,cost2,cost3};
//                int[] energy= {2,3,5};
//                solve1(S,cnt,cst,energy,0,0,0);
//                if(k!=Integer.MAX_VALUE)
//                    return k;
//                return -1;
//            }
//
//            static void solve1(int S,int[] cnt,int[] cst,int[] energy,int sum,int sum1,int cnt1) {
//                if(sum1==S){
//
//                    return;
//                }
//                for(int i=cnt1;i<3;i++){
//                    int s1=sum,s2=sum1;
//                    for(int j=1;j<=cnt[i];j++) {
//                        sum += cst[i];
//                        sum1 += energy[i];
//                        if(sum1>S)
//                            break;
//                        solve1(S,cnt,cst,energy,sum,sum1,i+1);
//                    }
//                    sum=s1;
//                    sum1=s2;
//                }
//            }
//        }
//
//        public static String maxSubstring(String s) {
//            char[] arr = s.toCharArray();
//            int l = s.length();
//            List<String> strings = new ArrayList<>();
//            for (int i=0;i<l;i++){
//                StringBuilder stringBuilder = new StringBuilder();
//                stringBuilder.append(arr[i]);
//                strings.add(stringBuilder.toString());
//                for(int j=i+1;j<l;j++){
//                    stringBuilder.append(arr[j]);
//                    strings.add(stringBuilder.toString());
//                }
//            }
//
//            Collections.sort(strings);
//            return strings.get(strings.size()-1);
//        }
//
//
//
//
//
//
//
//
//
//        public static void backtrack(List<Integer> arr,int index,int n,int threshold,int count,List<List<Integer>> subarrs){
//            if(count>threshold)
//                return;
//            if( index ==n ){
//                int sum =0;
//                //System.out.println(subarrs);
//                for(List<Integer> integers:subarrs){
//                    sum += Collections.max(integers);
//                }
//                if(sum < min)
//                    min=sum;
//            }
//
//            List<Integer> path=new ArrayList<>();
//            count =0;
//            for(int j=index;j<n;j++) {
//                path.add(arr.get(j));
//                subarrs.add(path);
//                count = count + 1;
//                backtrack(arr,j+1,n,threshold,count,subarrs);
//
//                subarrs.remove(subarrs.size()-1);
//            }
//        }
//        static int min = Integer.MAX_VALUE;
//        public static int calculateCost(List<Integer> arr, int threshold) {
//            //System.out.println(threshold+ " " +arr);
//            backtrack(arr,0,arr.size(),threshold,0,new ArrayList<>());
//            return min;
//        }
//
//
//
//
//        public static void backtrack(List<Integer> arr,int index,int n,int threshold,int count,List<Integer> subarrs){
//            if(count>threshold)
//                return;
//            if(index ==n){
//                int sum =0;
//                System.out.println(subarrs);
//                for(Integer integers:subarrs){
//                    sum += integers;
//                }
//                if(sum < min)
//                    min=sum;
//            }
//
//            List<Integer> path=new ArrayList<>();
//            count =0;
//            int max =arr.get(index);
//            for(int j=index;j<n;j++) {
//                if(arr.get(j)<max)
//                    max = arr.get(j);
//                path.add(arr.get(j));
//                subarrs.add(max);
//                count = count + 1;
//                backtrack(arr,j+1,n,threshold,count,subarrs);
//
//                subarrs.remove(subarrs.size()-1);
//            }
//        }
//
//        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//            if(root==null)
//                return null;
//            Stack<TreeNode> queue1 = new Stack<>();
//            Stack<TreeNode> queue2 = new Stack<>();
//            Stack<TreeNode> queue3;
//            queue1.push(root);
//            List<List<Integer>> lists = new ArrayList<>();
//            List<Integer> list = new ArrayList<>();
//            boolean first = true;
//            queue3=queue1;
//            TreeNode node;
//            while (!queue3.isEmpty()){
//                node=queue3.pop();
//                list.add(node.val);
//                if(first){
//                    if(node.left!=null)
//                        queue2.add(node.left);
//                    if(node.right!=null)
//                        queue2.add(node.right);
//                }
//                else{
//                    if(node.right!=null)
//                        queue1.add(node.right);
//                    if(node.left!=null)
//                        queue1.add(node.left);
//                }
//                if(queue3.isEmpty()){
//                    lists.add(list);
//                    list = new ArrayList<>();
//                    if(first){
//                        queue3=queue2;
//                        first=false;
//                    }
//                    else{
//                        queue3=queue1;
//                        first=true;
//                    }
//                }
//            }
//            return lists;
//        }
//
//        public int numIslands(char[][] grid) {
//            int r= grid.length;
//            if(r==0)
//                return 0;
//            int c = grid[0].length;
//            int count =0;
//            for(int i=0;i<r;i++){
//                for(int j=0;j<c;j++){
//                    if(grid[i][j]=='1'){
//                        count++;
//                        Stack<int[]> stack = new Stack<>();
//                        stack.push(new int[]{i,j});
//                        while (!stack.empty()){
//                            int[] ar = stack.pop();
//                            grid[ar[0]][ar[1]] = '0';
//                            int i1=ar[0],j1=ar[1];
//                            if(i1-1>=0&&grid[i1-1][j1]=='1'){
//                                stack.push(new int[]{i1-1,j1});
//                            }
//                            if(i1+1<r&&grid[i1+1][j1]=='1'){
//                                stack.push(new int[]{i1+1,j1});
//                            }
//                            if(j1-1>=0&&grid[i1][j1-1]=='1'){
//                                stack.push(new int[]{i1,j1-1});
//                            }
//                            if(j1+1<c&&grid[i1][j1+1]=='1'){
//                                stack.push(new int[]{i1,j1+1});
//                            }
//                        }
//                    }
//                }
//            }
//            return count;
//        }
//
//        public static void main(String args[] ) throws Exception {
//
//
//            Scanner s = new Scanner(System.in);
//            int n = Integer.parseInt(s.nextLine());
//            String[] arr = s.nextLine().split(",");
//
//            Map<String,List<String>> map = new HashMap<>();
//            for(String s1:arr){
//                String[] arr1 =  s1.split(":");
//                if(map.containsKey(arr1[1])){
//                    List<String> str = map.get(arr1[1]);
//                    str.add(arr1[0]);
//                    map.put(arr1[1], str);
//                }else{
//
//                    map.put(arr1[1], Collections.singletonList(arr1[0]));
//                }
//                Collections.sort(map);
//
//            }
//        }
//
//            Scanner s = new Scanner(System.in);
//            int n = Integer.parseInt(s.nextLine());
//            String[] arr = s.nextLine().split(",");
//            List<List<Integer>> lists = new ArrayList<>();
//            for(String s1: arr){
//                String[] arr1 =s1.split(":");
//                List<Integer> a1= new ArrayList<>();
//                a1.add(Integer.parseInt(arr1[0]));
//                a1.add(Integer.parseInt(arr1[1]));
//                lists.add(a1);
//            }
//            lists.sort(Comparator.comparing(x -> Math.abs(x.get(0)-x.get(1))));
//            Map<Integer,Set<List<Integer>>> map = new HashMap<>();
//            map.put(1,new HashSet<>(Collections.singletonList(lists.get(0))));
//            map.put(1,new HashSet<>(map.get(1)).add(lists.get(0)));
//            int key=0;
//            for(int i=1;i<size;i++){
//                for(Map.Entry<Map<Integer,Set<List<Integer>>> map = new HashMap<>();
//                int key=0;
//                for(int i=1;i<size;i++){
//                    for(Map<Integer,Set<List<Integer>>>.Entry)>: map.entrySet())
//            int count =1,size = lists.size();
//            boolean skip = false;
//            for(int i=1;i<size;i++){
//                List<Integer> list1 = lists.get(i);
//                List<Integer> list2 = lists.get(i-1);
//                if(skip){
//                    count++;
//                }
//                if(size  <  Math.ceil(Math.sqrt(Math.pow(list2.get(0)-list1.get(0),2) + Math.pow(list2.get(1)-list1.get(1),2)))){
//                    skip=true;
//                }
//
//
//
//            }
//            System.out.println(count);
//        }
//
//        public static void main(String args[] ) throws Exception {
//
//        Scanner s = new Scanner(System.in);
//        int n = Integer.parseInt(s.nextLine());
//        String[] arr = s.nextLine().split(",");
//        List<List<Integer>> lists = new ArrayList<>();
//        for(String s1: arr){
//            String[] arr1 =s1.split(":");
//            List<Integer> a1= new ArrayList<>();
//            a1.add(Integer.parseInt(arr1[0]));
//            a1.add(Integer.parseInt(arr1[1]));
//            lists.add(a1);
//        }
//        lists.sort(Comparator.comparing(x -> x.get(0)));
//
//        System.out.println(lists);
//        }
//
//
//        public List<List<Integer>> levelOrder(TreeNode root) {
//            if(root==null)
//                return null;
//            Queue<TreeNode> queue1 = new LinkedList<>();
//            Queue<TreeNode> queue2 = new LinkedList<>();
//            Queue<TreeNode> queue3;
//            queue3= queue1;
//            queue1.add(root);
//            List<List<Integer>> lists = new ArrayList<>();
//            List<Integer> list = new ArrayList<>();
//            boolean first = true;
//            TreeNode node;
//            while (!queue3.isEmpty()){
//                node=queue3.poll();
//                list.add(node.val);
//                if(node.left!=null){
//                    if(first){
//                        queue2.add(node.left);
//                    }else{
//                        queue1.add(node.left);
//                    }
//                }
//                if(node.right!=null){
//                    if(first){
//                        queue2.add(node.right);
//                    }else{
//                        queue1.add(node.right);
//                    }
//                }
//                if(queue3.isEmpty()){
//                    lists.add(list);
//                    list = new ArrayList<>();
//                    if(first){
//                        queue3=queue2;
//                        first=false;
//                    }
//                    else{
//                        queue3=queue1;
//                        first=true;
//                    }
//                }
//            }
//           return lists;
//
//        }
//
//        static int max = Integer.MIN_VALUE;
//        public static void main(String[] args) {
//
//            Scanner sc = new Scanner(System.in);
//            int t = sc.nextInt();
//            for (int d = 0; d < t; d++) {
//                int n = sc.nextInt();
//                List<List<Double>> classes = new ArrayList<>();
//                List<Double> d2 = new ArrayList<>();
//                d2.add(0.0);
//                d2.add(0.0);
//                classes.add(d2);
//                for(int i=0;i<n;i++){
//                    String s = sc.next();
//                    String[] startTime = sc.next().split(":");
//                    String[] endTime = sc.next().split(":");
//                    List<Double> d1 = new ArrayList<>();
//                    d1.add((Double.parseDouble(startTime[0]) +Double.parseDouble(startTime[1])/60));
//                    d1.add((Double.parseDouble(endTime[0]) +Double.parseDouble(endTime[1])/60));
//                    classes.add(d1);
//                }
//                classes.sort(Comparator.comparing(x -> x.get(1)));
//                int count =1;
//                int j=0;
//                for(int i=1;i<n;i++){
//                    if(classes.get(i).get(0)>=classes.get(j).get(1)){
//                        count+=1;
//                        j=i;
//                    }
//                }
//                System.out.println(count);
//                List<Double> timing = new ArrayList<>();
//                for(int i=0;i<=23;i++){
//                    for(int j=0;j<=59;j++){
//                        timing.add((double) (i+j/60));
//                    }
//
//                }
//                int rows = timing.size();
//                int columns = classes.size();
//                int values[][] = new int[rows+1][columns+1];
//                for(int i=0;i<=rows;i++){
//                    for(int j=0;j<columns;j++){
//                        if(i==0 || j==0) {
//                            values[i][j] = 0;
//                            continue;
//                        }
//                        if(classes.get(j).get(0)<=timing.get(i)){
//                            if(classes.get(j-1).get(1)<=classes.get(j).get(0)){
//                                values[i][j] = Math.max(values[i-1][j-1]+1,Math.max(values[i][j-1],values[i-1][j]));
//                            }
//                            else{
//                                values[i][j] = Math.max(values[i-1][j-1]+1,Math.max(values[i][j-1],values[i-1][j]));
//                            }
//
//                        }else{
//                            values[i][j] = Math.max(values[i-1][j-1],Math.max(values[i][j-1],values[i-1][j]));
//                        }
//
//                    }
//                }
//
//                traverse(classes,0,n,0.0,0);
//                System.out.println(max);
//            }
//
//        }
//        public static void  traverse(List<List<Double>> lists, int index,int n,double lastTime,int maximum){
//            if(maximum>max){
//                max=maximum;
//            }
//            for(int i=index;i<n;i++){
//                if(lastTime<=lists.get(i).get(0)){
//                    maximum+=1;
//                    lastTime=lists.get(i).get(1);
//                    traverse(lists, index+1, n, lastTime,maximum);
//                    maximum-=1;
//                }
//            }
//        }
//
//        public static int calculateCost(List<Integer> arr, int threshold) {
//            System.out.println(threshold+ " " +arr);
//            backtrack(arr,0,arr.size(),threshold,0,new ArrayList<>());
//            return min;
//        }
//
//        class Node {
//            public int val;
//            public Node left;
//            public Node right;
//            public Node next;
//
//            public Node() {}
//
//            public Node(int _val) {
//                val = _val;
//            }
//
//            public Node(int _val, Node _left, Node _right, Node _next) {
//                val = _val;
//                left = _left;
//                right = _right;
//                next = _next;
//            }
//        };
//        public Node connect(Node root) {
//            Map<Integer,List<Node>> map =new HashMap<>();
//            traverse(map,0,root);
//            for(Map.Entry<Integer,List<Node>> integerListEntry:map.entrySet()){
//                List<Node> nodes = integerListEntry.getValue();
//                int size = nodes.size();
//                for(int i=0;i<size-1;i++){
//                    nodes.get(i).next = nodes.get(i+1);
//                }
//                nodes.get(size-1).next = null;
//            }
//             return root;
//        }
//
//        public void traverse(Map<Integer,List<Node>> map, int height,Node root){
//            if(root ==null)
//                return;
//            List<Node> nodes = new ArrayList<>();
//            if(map.containsKey(height)){
//                nodes=map.get(height);
//            }
//            nodes.add(root);
//            map.put(height,nodes);
//            traverse(map,height+1,root.left);
//            traverse(map,height+1,root.right);
//        }
//
//        public int minSteps(String s, String t) {
//            int sl = s.length();
//            char[] sc = s.toCharArray();
//            char[] tc = t.toCharArray();
//            Map<Character,Integer> sMap = new HashMap<>();
//            Map<Character,Integer> tMap = new HashMap<>();
//            for(int i=0;i<sl;i++){
//                char schar = sc[i];
//                char tchar = tc[i];
//                if(schar==tchar)
//                    continue;
//                if(sMap.containsKey(schar)){
//                    sMap.put(schar,sMap.get(schar)+1);
//                }else{
//                    sMap.put(schar,1);
//                }
//
//                if(tMap.containsKey(tchar)){
//                    tMap.put(tchar,tMap.get(tchar)+1);
//                }else{
//                    tMap.put(tchar,1);
//                }
//            }
//            int count =0;
////            for(Map.Entry<Character,Integer> characterIntegerEntry: sMap.entrySet()){
////                if(tMap.containsKey(characterIntegerEntry.getKey())){
////                    int val = tMap.get(characterIntegerEntry.getKey()) - characterIntegerEntry.getValue();
////                    if(val>0){
////                        count+=val;
////                    }
////                    tMap.remove(characterIntegerEntry.getKey());
////                }
////            }
//            for(Map.Entry<Character,Integer> characterIntegerEntry: tMap.entrySet()){
//                if(sMap.containsKey(characterIntegerEntry.getKey())){
//                    int val = characterIntegerEntry.getValue()-sMap.get(characterIntegerEntry.getKey());
//                    if(val>0){
//                        count+=val;
//                    }
//                    tMap.remove(characterIntegerEntry.getKey());
//                }else {
//                    count += characterIntegerEntry.getValue();
//                }
//            }
//            return count;
//        }
//
//        public Node connect(Node root) {
//            if(root==null)
//                return null;
//            root.next = null;
//            traverse(root);
//            return root;
//        }
//        public void traverse(Node root){
//            if(root==null || (root.left==null && root.right==null))
//                return;
//            if(root.right!=null&& root.left!=null) {
//                root.left.next = root.right;
//                setRight(root);
//                traverse(root.left);
//                traverse(root.right);
//                return;
//            }
//            if(root.right == null){
//                if(root.next!=null){
//                    if(root.next.left!=null){
//                        root.left.next = root.next.left;
//                    }
//                    else{
//                        root.left.next = root.next.right;
//                    }
//                }
//                else root.left.next=null;
//                traverse(root.left);
//                return;
//            }
//            setRight(root);
//            traverse(root.right);
//        }
//
//        public void setRight(Node root){
//            if(root.next!=null){
//                if(root.next.left!=null){
//                    root.right.next = root.next.left;
//                }
//                else{
//                    root.right.next = root.next.right;
//                }
//            }
//            else root.right.next=null;
//        }
//
//            public static void main(String[] args) {
//
//            Scanner sc = new Scanner(System.in);
//            int t = sc.nextInt();
//            for (int d = 0; d < t; d++) {
//                int n = sc.nextInt();
//                List<List<Double>> classes = new ArrayList<>();
//                for (int i = 0; i < n; i++) {
//                    String s = sc.next();
//                    String[] startTime = sc.next().split(":");
//                    String[] endTime = sc.next().split(":");
//                    List<Double> d1 = new ArrayList<>();
//                    d1.add((Double.parseDouble(startTime[0]) + Double.parseDouble(startTime[1]) / 60));
//                    d1.add((Double.parseDouble(endTime[0]) + Double.parseDouble(endTime[1]) / 60));
//                    classes.add(d1);
//                }
//                classes.sort(Comparator.comparing(x -> x.get(1)));
//                System.out.println(classes);
//                int count = 1;
//                int j = 0;
//                for (int i = 1; i < n; i++) {
//                    if (classes.get(i).get(0) >= classes.get(j).get(1)) {
//                        count += 1;
//                        j = i;
//                    }
//                }
//                System.out.println(count);
//            }
//        }
//
//
//        public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
//            List<List<Integer>> events = new ArrayList<>();
//            int size = arrival.size();
//            for(int i=0;i<size;i++){
//                List<Integer> integers = new ArrayList<>();
//                integers.add(arrival.get(i));
//                integers.add(arrival.get(i)+duration.get(i));
//                events.add(integers);
//            }
//            events.sort(Comparator.comparing(x -> x.get(1)));
//            int count = 1;
//            int j = 0;
//            for (int i = 1; i < size; i++) {
//                if (events.get(i).get(0) >= events.get(j).get(1)) {
//                    count += 1;
//                    j = i;
//                }
//            }
//            return count;
//        }
//
//        public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
//            int size = a.size();
//            List<Integer> list = new ArrayList<>();
//            for(int i=0;i<size;i++){
//                Map<Character,Integer> a1= new HashMap<>();
//                Map<Character,Integer> b1= new HashMap<>();
//                if(a.get(i).length()!=b.get(i).length()){
//                    list.add(-1);
//                    continue;
//                }
//                char[] arr = a.get(i).toCharArray();
//                char[] brr = b.get(i).toCharArray();
//                setMap(a1,arr);
//                setMap(b1,brr);
//                System.out.println(a1);
//                System.out.println(b1);
//                int count1 =0,count2=0;
//                for(Map.Entry<Character,Integer> map:a1.entrySet()){
//                    if(b1.containsKey(map.getKey())) {
//                        if(b1.get(map.getKey())>map.getValue()){
//                            count2 += b1.get(map.getKey()) - map.getValue();
//                        }else{
//                            count1 += map.getValue() - b1.get(map.getKey());
//                        }
//                        b1.remove(map.getKey());
//                    }else{
//                        count1+=map.getValue();
//                    }
//                }
//                for(Map.Entry<Character,Integer> map:b1.entrySet()){
//                    count2+=map.getValue();
//                }
//                list.add(Math.max(count1, count2));
//            }
//            return list;
//        }
//
//        public static List<Integer> getTheGroups(int n, List<String> queryType, List<Integer> students1, List<Integer> students2) {
//
//            Map<Integer,Set<Integer>> integerListMap = new HashMap<>();
//            int size = queryType.size();
//            List<Integer> integers = new ArrayList<>();
//            for(int i=0;i<size;i++){
//                if(queryType.get(i).equals("Friend")){
//                    Set<Integer> integers1;
//                    if(integerListMap.containsKey(students1.get(i))){
//                        integers1 = integerListMap.get(students1.get(i));
//                    }else{
//                        integers1 = new HashSet<>();
//                    }
//                    integers1.add(students2.get(i));
//                    integerListMap.put(students1.get(i),integers1);
//
//                    if(integerListMap.containsKey(students2.get(i))){
//                        integers1 = integerListMap.get(students2.get(i));
//                    }else{
//                        integers1 = new HashSet<>();
//                    }
//                    integers1.add(students1.get(i));
//                    integerListMap.put(students2.get(i),integers1);
//                }
//                else{
//                    int val1 = students1.get(i);
//                    int val2= students2.get(i);
//                    Set<Integer> integerSet1 = new HashSet<>();
//                    Set<Integer> integerSet2 = new HashSet<>();
//                    integerSet1.add(val1);
//                    integerSet2.add(val2);
//                    if(integerListMap.containsKey(val1)){
//                        for(Integer i1 :integerListMap.get(val1)){
//                            integerSet1.add(i1);
//                            if(integerListMap.containsKey(i1)){
//                                integerSet1.addAll(integerListMap.get(i1));
//                            }
//                        }
//                    }
//                    if(integerListMap.containsKey(val2)){
//                        for(Integer i1 :integerListMap.get(val2)){
//                            integerSet2.add(i1);
//                            if(integerListMap.containsKey(i1)){
//                                integerSet2.addAll(integerListMap.get(i1));
//                            }
//                        }
//                    }
//
//                    integers.add(integerSet1.size()+integerSet2.size());
//                }
//            }
//            return integers;
//
//
//        }
//
//        public int findCircleNum(int[][] M) {
//            int r = M.length;
//            int c= M[0].length;
//            boolean[][] seen = new boolean[r][c];
//            int count =0;
//
//            for(int i=0;i<r;i++){
//                for(int j=0;j<c;j++){
//                    if(M[i][j]==1 && !seen[i][j]){
//                        count+=1;
//                        Stack<int[]> stack = new Stack<>();
//                        stack.push(new int[]{i,j});
//                        while (!stack.empty()){
//                            int[] arr =  stack.pop();
//                            if(arr[0]>=0 && arr[0]<r&&arr[1]>=0 && arr[1]<c){
//                                int i1=arr[0],j1=arr[1];
//                                seen[i1][j1]=true;
//                                if(M[i1][j1]==1){
//                                    if(i1+1<r&& M[i1+1][j1] ==1&& !seen[i1+1][j1])
//                                        stack.push(new int[]{i1+1,j1});
//                                    if(i1 - 1 >= 0 && M[i1 - 1][j1] == 1&& !seen[i1-1][j1])
//                                        stack.push(new int[]{i1-1,j1});
//                                    if(j1+1<c&& M[i1][j1+1] ==1&& !seen[i1][j1+1])
//                                        stack.push(new int[]{i1,j1+1});
//                                    if(j1-1>=0&& M[i1][j1-1] ==1 && !seen[i1][j1-1])
//                                        stack.push(new int[]{i1,j1-1});
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            return count;
//        }
//
//        public boolean canJump(int[] nums) {
//            int l=nums.length;
//            int c=0;
//            for(int i=l-1;i>=0;i++){
//                c++;
//                if (nums[i]>=c)
//                    c=0;
//            }
//            return c==0;
//        }
//
//        private static void setMap(Map<Character,Integer> a1,char[] arr){
//            for(char x: arr){
//                if(a1.containsKey(x)){
//                    a1.put(x,a1.get(x)+1);
//                }else{
//                    a1.put(x,1);
//                }
//            }
//
//        }
//
//
//
//
////        public Pair<Integer,Integer> traverse(TreeNode root){
////            if(root.left==null&& root.right==null)
////                return new Pair<>(root.val,root.val);
////            if(root.left!=null && root.right!=null){
////                Pair<Integer,Integer> lPair = traverse(root.left);
////                Pair<Integer,Integer> rPair = traverse(root.right);
////                int val = Math.max(lPair.getValue(),Math.max(lPair.getKey(),Math.max(rPair.getKey(),Math.max(rPair.getValue(),root.val+lPair.getKey()+rPair.getKey()))));
////                int key = Math.max(root.val,Math.max(root.val+lPair.getKey(),root.val+rPair.getKey()));
////                return new Pair<>(key,val);
////            }else if(root.left!=null) {
////                Pair<Integer,Integer> lPair = traverse(root.left);
////                int val = Math.max(lPair.getValue(),Math.max(lPair.getKey(),root.val+lPair.getKey()));
////                int key = Math.max(root.val,root.val+lPair.getKey());
////                return new Pair<>(key,val);
////
////            }
////            Pair<Integer,Integer> rPair = traverse(root.right);
////            int val = Math.max(rPair.getValue(),Math.max(rPair.getKey(),root.val+rPair.getKey()));
////            int key = Math.max(root.val,root.val+rPair.getKey());
////            return new Pair<>(key,val);
////        }
//
//        public int rob(TreeNode root) {
//            Pair<Integer,Integer> pair =traverse(root);
//            return pair.getKey()>pair.getValue() ? pair.getKey() : pair.getValue();
//        }
//        public Pair<Integer,Integer> traverse(TreeNode root){
//            if(root ==null)
//                return new Pair<>(0,0);
//            Pair<Integer,Integer> lPair = traverse(root.left);
//            Pair<Integer,Integer> rPair = traverse(root.right);
//            int lmax = Math.max(lPair.getKey(),lPair.getValue());
//            int rmax = Math.max(rPair.getKey(),rPair.getValue());
//            return new Pair<>(root.val+lPair.getValue()+rPair.getValue(),lmax+rmax);
//        }
//
//        public int longestCommonSubsequence(String text1, String text2) {
//            int m = text1.length();
//            int n = text2.length();
//            int[][] arr = new int[m+1][n+1];
//            for(int i=0;i<=m;i++){
//                for(int j=0;j<=n;j++){
//                    if(i==0 || j==0) {
//                        arr[i][j] = 0;
//                        continue;
//                    }
//                    if(text1.charAt(i)==text2.charAt(j)){
//                        arr[i][j] = arr[i-1][j-1]+1;
//                    }else{
//                        arr[i][j]=Math.max(arr[i][j-1],Math.max(arr[i-1][j],arr[i-1][j-1]));
//                    }
//                }
//            }
//            return arr[m][n];
//        }
//
//        public int longestPalindromeSubseq(String s) {
//
//        }
//
//        public int deleteAndEarn(int[] nums) {
//            int l =nums.length;
//            if(l==0)
//                return 0;
//            Map<Integer,Integer> integerIntegerMap =new HashMap<>();
//            List<Integer> list = new ArrayList<>();
//            for(int i=0;i<l;i++){
//                if(integerIntegerMap.containsKey(nums[i])){
//                    integerIntegerMap.put(nums[i],integerIntegerMap.get(nums[i])+1);
//
//                }else {
//                    integerIntegerMap.put(nums[i], 1);
//                    list.add(nums[i]);
//                }
//            }
//            int s = list.size();
//            int[] arr = new int[s];
//            arr[0] = list.get(0)*integerIntegerMap.get(list.get(0));
//            if(s==1)
//                return arr[0];
//            Collections.sort(list);
//            arr[1] = list.get(1)*integerIntegerMap.get(list.get(1));
//            if(list.get(0)+1 == list.get(1)){
//                arr[1] = Math.max(arr[1],arr[0]);
//            }else{
//                arr[1] +=arr[0];
//            }
//            if(s==2)
//                return arr[1];
//            for(int i=2;i<s;i++){
//                arr[i] = list.get(i)*integerIntegerMap.get(list.get(i));
//                if(list.get(i)-1 == list.get(i-1)){
//                    arr[i] = Math.max(arr[i]+arr[i-2],arr[i-1]);
//                }else{
//                    arr[i] +=arr[i-1];
//                }
//            }
//            System.out.println(Arrays.toString(arr));
//            return arr[s-1];
//
//
//        }
//
//        public static void main(String[] args) {
//
//            Scanner sc = new Scanner(System.in);
//            int t = sc.nextInt();
//            for (int n = 0; n < t; n++) {
//                String a = sc.next();
//                int l = a.length();
//                Set<String> strings = new HashSet<>();
//                permute(a.toCharArray(),strings,0,l-1);
//                List<String> strings1 = new ArrayList<>(strings);
//                Collections.sort(strings1);
//                int s = strings1.size();
//                for(int i=0;i<s;i++){
//                    System.out.print(strings1.get(i) + " ");
//                }
//                System.out.println();
//
//            }
//
//        }
//        public static void permute(char[] arr,Set<String> strings,int l,int r){
//            if(l==r){
//                strings.add(String.valueOf(arr));
//                return;
//            }
//            for(int i=l;i<=r;i++){
//                char a = arr[i];
//                arr[i] = arr[l];
//                arr[l] = a;
//                permute(arr,strings,l+1,r);
//                a=arr[i];
//                arr[i] = arr[l];
//                arr[l] = a;
//            }
//        }
//
//
//        public int  maxPathSum(TreeNode root) {
//            Pair<Integer,Integer> pair =traverse(root);
//            return Math.max(pair.getValue(),pair.getKey());
//
//        }
//
//
//        public static void main(String[] args) {
//
//            Scanner sc = new Scanner(System.in);
//            int n = sc.nextInt();
//            for (int i = 0; i < n; i++) {
//                String s1 = sc.next();
//                String s2 = sc.next();
//                int s1L = s1.length();
//                int s2L = s2.length();
//                int i1 = 0, j = 0;
//                boolean found = false;
//                for (; i1 < s1L; i1++) {
//                    if (s1.charAt(i1) == s2.charAt(j)) {
//                        j++;
//                        if (j == s2L) {
//                            found = true;
//                            break;
//                        }
//                    }
//                }
//                if (found)
//                    System.out.println("YES");
//                else System.out.println("NO");
//            }
//        }
////                    char[] s1Arr = s1.toCharArray();
//////                    char[]
//////                    String[] startTime = sc.next().split(":");
//////                    String[] endTime = sc.next().split(":");
//////                    List<Double> d1 = new ArrayList<>();
//////                    d1.add((Double.parseDouble(startTime[0]) + Double.parseDouble(startTime[1]) / 60));
//////                    d1.add((Double.parseDouble(endTime[0]) + Double.parseDouble(endTime[1]) / 60));
//////                    classes.add(d1);
//////                }
//////                classes.sort(Comparator.comparing(x -> x.get(1)));
//////                System.out.println(classes);
//////                int count = 1;
//////                int j = 0;
//////                for (int i = 1; i < n; i++) {
//////                    if (classes.get(i).get(0) >= classes.get(j).get(1)) {
//////                        count += 1;
//////                        j = i;
//////                    }
//////                }
//////                System.out.println(count);
//////            }
//////        }
//
//
//        public boolean isBalanced(TreeNode root) {
//            return traverse(root).getValue();
//
//        }
//        public Pair<Integer,Boolean> traverse(TreeNode treeNode){
//            if(treeNode == null)
//                return new Pair<>(0,true);
//            Pair<Integer,Boolean> left = traverse(treeNode.left);
//            Pair<Integer,Boolean> right =traverse(treeNode.right);
//            if(Math.abs(left.getKey()-right.getKey())>1)
//                return new Pair<>(Math.max(left.getKey(),right.getKey())+1,false);
//            return new Pair<>(Math.max(left.getKey(),right.getKey())+1,left.getValue()&&right.getValue());
//        }
//        public int[] searchRange(int[] nums, int target) {
//            int l = nums.length;
//            int min = 0,max=l,mid=l/2;
//            while(min!=max){
//                if(nums[mid] == target){
//                    break;
//                }
//                if(nums[mid]<target){
//                    min = mid+1;
//                }
//                else {
//                    max=mid-1;
//                }
//                mid=(min+max)/2;
//                System.out.println(min);
//                System.out.println(max);
//            }
//            if(min==max||min>max){
//                return new int[]{-1,-1};
//            }
//            int end=mid,start=mid;
//            for(;start>=0;start--){
//                if(nums[start]!=target)
//                    break;
//            }
//            for(;end<l;end++){
//                if(nums[end]!=target)
//                    break;
//            }
//            return new int[]{start+1,end-1};
//
//        }
//
//        static class Main {
//            public static void main(String args[]) {
//                System.out.println(Iamsleeping());
//            }
//            static String Iamsleeping()(int str1 = 'Iamsleeping')
//            {
//                return str1;
//            }
//        }
//
//        public String minWindow(String s, String t) {
//            Map<Character,Integer> tMap = new HashMap<>();
//            int tL = t.length();
//            for(int i=0;i<tL;i++){
//                tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
//            }
//            int tKeySize = tMap.size();
//            Map<Character,Integer> sMap = new HashMap<>();
//            int l=0,r=0,sKey=0;
//            int sL = s.length();
//            while(r<sL){
//                sMap.put(s.charAt(r),tMap.getOrDefault(s.charAt(r),0)+1);
//                if(tMap.containsKey(s.charAt(r)) && tMap.get(s.charAt(r)) == sMap.get(s.charAt(r))){
//                    sKey++;
//                }
//                while(tKeySize==sKey && l<=r){
//
//                    l++;
//                }
//                r++;
//            }
//        }
//
//        public int lengthOfLongestSubstring(String s) {
//            char[] arr = s.toCharArray();
//            int l = s.length();
//            int j=0,max =0;
//            Set<Character> c = new HashSet<>();
//            for(int i=0;i<l;i++){
//                if(c.contains(arr[i])){
//                    c=new HashSet<>();
//                    max=Math.max(max,i-j);
//                    j=i;
//                }
//                else{
//                    c.add(arr[i]);
//                }
//            }
//            return max;
//        }
//
//        public int maxAreaOfIsland(int[][] grid) {
//            int m = grid.length;
//            int n = grid[0].length;
//            int[][] output = new int[m][n];
//            int max =0;
//            for(int i=0;i<m;i++){
//                for(int j=0;j<n;j++){
//                    if(grid[i][j]==0){
//                        output[i][j]=0;
//                        continue;
//                    }
//
//                    if(i==0&&j==0)
//                        output[i][j]=grid[i][j];
//                    else if(i==0) {
//                        output[i][j] = grid[i][j] + output[i][j - 1];
//                    }
//                    else if(j==0) {
//                        output[i][j] = grid[i][j] + output[i - 1][j];
//                    }
//                    else{
//                        output[i][j] = output[i-1][j]+output[i][j-1]+1;
//                        if(grid[i-1][j-1]==1 && grid[i][j-1]==1 && grid[i-1][j]==1)
//                            output[i][j] -= output[i-1][j-1];
//                    }
//                }
//            }
//            return max;
//
//        }
//
//        public static void main(String[] args) {
//
//            Scanner sc = new Scanner(System.in);
//            int t = sc.nextInt();
//            for (int t1 = 0; t1 < t; t1++) {
//                int boyCount = sc.nextInt();
//                int[] boysSkill = new int[boyCount];
//                for(int i=0;i<boyCount;i++){
//                    boysSkill[i]= sc.nextInt();
//                }
//                int girlCount = sc.nextInt();
//                int[] girlsSkill = new int[girlCount];
//                Map<Integer,Integer> girlsMap = new HashMap<>();
//                for(int i=0;i<girlCount;i++){
//                    girlsSkill[i]= sc.nextInt();
//                    if(girlsMap.containsKey(girlsSkill[i])) {
//                        girlsMap.put(girlsSkill[i],girlsMap.get(girlsSkill[i])+1);
//                    }else
//                    girlsMap.put(girlsSkill[i],1);
//                }
//                int count =0;
//                for(int i=0;i<boyCount;i++){
//                    int boyskill = boysSkill[i];
//                    int key =0;
//                    boolean match = false;
//                    if(girlsMap.containsKey(boyskill)){
//                        match= true;
//                        key = boyskill;
//                    }
//                    else if(girlsMap.containsKey(boyskill-1)){
//                        match=true;
//                        key= boyskill-1;
//                    }
//                    else if (girlsMap.containsKey(boyskill+1)){
//                        match=true;
//                        key= boyskill+1;
//                    }
//                    if(match){
//                        count+=1;
//                        int number = girlsMap.get(key);
//                        number--;
//                        if(number==0)
//                            girlsMap.remove(key);
//                        else
//                            girlsMap.put(key,number);
//                    }
//                }
//                System.out.println(count);
//            }
//
//        }
//        public int scheduleCourse(int[][] courses) {
//            Arrays.sort(courses,Comparator.comparing(course -> course[1]));
//            System.out.println(Arrays.deepToString(courses));
//            int n = courses.length;
//            int count =1;
//            int j=0;
//            for(int i=1;i<n;i++){
//                if(courses[i][0]>courses[j][1]){
//                    j=i;
//                    count+=1;
//                }
//            }
//            return count;
//        }
//
//        public int longestPalindromeSubseq(String s) {
//            int l = s.length();
//        }
//
//        public int[][] merge(int[][] intervals) {
//            int l = intervals.length;
//            for(int i=0;i<l;i++){
//                for(int j=i+1;j<l;j++){
//                    int temp=intervals[i][0];
//                    if(temp>intervals[j][0]){
//                        intervals[i][0]=intervals[j][0];
//                        intervals[j][0] = temp;
//                        temp = intervals[i][1];
//                        intervals[i][1] = intervals[j][1];
//                        intervals[j][1] = temp;
//                    }
//                }
//            }
//            List<List<Integer>> inLists = new ArrayList<>();
//            List<Integer> integers = new ArrayList<>();
//            integers.add(intervals[0][0]);
//            integers.add(intervals[0][1]);
//            inLists.add(integers);
//            for(int i=1;i<l;i++){
//                if(intervals[i][0]<=inLists.get(i-1).get(1)){
//                    integers = inLists.get(i-1);
//                    integers.set(1,Math.max(intervals[i][1],integers.get(1)));
//                }
//                integers = new ArrayList<>();
//                integers.add(intervals[i][0]);
//                integers.add(intervals[i][1]);
//                inLists.add(integers);
//            }
//            System.out.println(inLists);
//            return new int[1][2];
//        }
//
//         public class ListNode {
//              int val;
//              ListNode next;
//              ListNode() {}
//              ListNode(int val) { this.val = val; }
//              ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//          }
//
//        public int findDuplicate(int[] nums) {
//            Map<Integer,Integer> integerSet = new HashMap<>();
//            for(int l:nums){
//                if(integerSet.containsKey(l))
//                    return l;
//                integerSet.put(l,1);
//            }
//            return -1;
//        }
//
//        public int kthSmallest(int[][] matrix, int k) {
//            int r=matrix.length;
//            int row=
//        }
//
//        public boolean isValid(String s) {
//            Stack<Character> characters = new Stack<>();
//            char[] arr= s.toCharArray();
//            for(Character c: arr){
//                if(c==')' || c==']' || c=='}') {
//                    if(characters.empty())
//                        return false;
//                    if (c == ')') {
//                        if (characters.pop() != '(')
//                            return false;
//                    } else if (c == ']') {
//                        if (characters.pop() != '[')
//                            return false;
//                    } else {
//                        if (characters.pop() != '{')
//                            return false;
//                    }
//                }
//                else characters.push(c);
//            }
//            return characters.empty();
//        }
//
//
//        public int lengthOfLIS(int[] nums) {
//            int l = nums.length;
//            int[] dp = new int[l];
//            int max =0;
//            for(int i=0;i<l;i++){
//                dp[i]=1;
//                for(int j=0;j<=i-1;j++){
//                    if(nums[i]>nums[j]){
//                        if(dp[i]<dp[j]+1)
//                            dp[i=dp[j]+1;
//                    }
//                }
//                if(dp[i]>max)
//                    max=dp[i];
//            }
//            return max;
//        }
//
//        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//            int l1 =0,l2=0;
//            ListNode temp = headA;
//            while(temp!=null){
//                l1++;
//                temp=temp.next;
//            }
//            temp = headB;
//            while(temp!=null){
//                l2++;
//                temp=temp.next;
//            }
//            int l=0;
//            ListNode temp2;
//            if(l1>=l2){
//                temp = headA;
//                temp2 = headB;
//                l=l1-l2;
//            }else {
//                temp=headB;
//                temp2 = headA;
//                l=l1-l1;
//            }
//            while(l!=0){
//                temp=temp.next;
//                l--;
//            }
//            while(temp!=null && temp2!=null){
//                if(temp==temp2){
//                    return temp;
//                }
//                temp=temp.next;
//                temp2=temp2.next;
//            }
//            return null;
//        }
//
//        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//            if(l1==null)
//                return l2;
//            if(l2==null)
//                return l1;
//            ListNode n1 = l1.val>l2.val? l2 : l1;
//            ListNode temp1 = n1;
//            ListNode temp2 = l1.val>l2.val? l1 : l2;
//            ListNode temp3;
//            while(temp1.next!=null && temp2.next!=null){
//                    if(temp2.val>temp1.next.val){
//                        temp1=temp1.next;
//                    }
//                    else{
//                        temp3=temp2.next;
//                        temp2.next=temp1.next;
//                        temp1.next=temp2;
//                        temp1=temp2;
//                        temp2=temp3;
//                    }
//            }
//            if(temp2!=null)
//            temp1.next=temp2;
//            return n1;
//        }
//
//        public boolean validMountainArray(int[] arr) {
//            int l = arr.length;
//            if(l<3)
//                return false;
//            int i=0;
//            for(;i<l-1;i++){
//                if(arr[i]>arr[i+1]){
//                    break;
//                }
//            }
//            if(i==l-1)
//                return false;
//            i++;
//            for(;i<l;i++){
//                if(arr[i]>arr[i-1])
//                    break;
//            }
//            if(i==l)
//                return true;
//            return false;
//        }
//
//        public int numPairsDivisibleBy60(int[] time) {
//            int l =time.length;
//            int[] arr = new int[60];
//            for(int i=0;i<60;i++){
//                arr[i] = 0;
//            }
//            for(int i=0;i<l;i++){
//                int val =time[i]%60;
//                arr[val]+=1;
//            }
//            int sum =0;
//            for(int i=0;i<60;i++){
//                int val =
//            }
//            return sum;
//        }
//
//        public int longestIncreasingPath(int[][] matrix) {
//            int rows = matrix.length;
//            int columns = matrix[0].length;
//            int[][] dp = new int[rows][columns];
//            for(int i=0;i<rows;i++){
//                for(int j=0;j<columns;j++)
//                    dp[i][j]=0;
//                }
//            int max =0;
//            for(int i=0;i<rows;i++){
//                for(int j=0;j<columns;j++){
//                    if(dp[i][j]==0) {
//                        int parent = matrix[i][j];
//                        dp[i][j] = 1 + Math.max(traverse(dp, rows, columns, i + 1, j, parent, matrix), Math.max(traverse(dp, rows, columns, i - 1, j, parent, matrix),
//                                Math.max(traverse(dp, rows, columns, i, j - 1, parent, matrix), traverse(dp, rows, columns, i, j + 1, parent, matrix))));
//                    }
//                    if(dp[i][j]>max)
//                        max=dp[i][j];
//                }
//            }
//            return max;
//        }
//
//        public int traverse(int[][] dp,int rows ,int columns,int i,int j,int parent,int[][] matrix){
//            if(i<0 || i>rows  || j<0 || j>=columns || dp[i][j]<parent)
//                return 0;
//            if(dp[i][j]!=0)
//                return dp[i][j];
//            int l =0;
//            int r=0;
//            int upside = 0;
//            int down = 0;
//            parent = matrix[i][j];
//            dp[i][j] = 1+Math.max(traverse(dp,rows,columns,i+1,j,parent,matrix),Math.max(traverse(dp,rows,columns,i-1,j,parent,matrix),
//                    Math.max(traverse(dp,rows,columns,i,j-1,parent,matrix),traverse(dp,rows,columns,i,j+1,parent,matrix))));
//            return dp[i][j];
//        }
//
//        public String longestPalindrome(String s) {
//            int l = s.length();
//            boolean[][] dp = new boolean[l][l];
//            int max =1;
//            int fromIndex = 0;
//            int toIndex = 0;
//            for(int i=0;i<l-1;i++) {
//                dp[i][i] = true;
//                dp[i][i+1] = s.charAt(i) == s.charAt(i + 1);
//                if(max <2 && dp[i][i+1]){
//                    max=2;
//                    fromIndex = i;
//                    toIndex=i+1;
//                }
//            }
//            dp[l-1][l-1]=true;
//            for(int len =3;len<=l;len++){
//                for(int i=0,j=len-(i+1);j<l;j++,i++){
//                    if(s.charAt(i) == s.charAt(j)){
//                        dp[i][j] = dp[i+1][j-1];
//                    }
//                    else{
//                        dp[i][j] = false;
//                    }
//                    if(dp[i][j] && j-i+1>max){
//                        max = j-i+1;
//                        fromIndex = i;
//                        toIndex = j;
//                    }
//                }
//            }
//
//            return s.substring(fromIndex,toIndex+1);
//        }
//
//        public int maxProfit(int[] prices) {
//            int maxProfit =0,minPrice = Integer.MAX_VALUE;
//            for(int price:prices){
//                if(minPrice>price)
//                    minPrice =price;
//                if(maxProfit<price-minPrice)
//                    maxProfit = price-minPrice;
//
//            }
//            return maxProfit;
//        }
//
//        public int maximalSquare(char[][] matrix) {
//
//        }
//
//        public int maxEnvelopes(int[][] intervals) {
//            int l = intervals.length;
//            for(int i=0;i<l;i++){
//                for(int j=i+1;j<l;j++){
//                    int temp=intervals[i][0];
//                    if(temp>intervals[j][0]){
//                        intervals[i][0]=intervals[j][0];
//                        intervals[j][0] = temp;
//                        temp = intervals[i][1];
//                        intervals[i][1] = intervals[j][1];
//                        intervals[j][1] = temp;
//                    }
//                }
//            }
//            int[] dp = new int[l];
//            int max =0;
//            for(int i=0;i<l;i++){
//                dp[i]=1;
//                for(int j=0;j<i;j++){
//                    if(intervals[i][0]>intervals[j][0] && intervals[i][1]>intervals[j][1])
//                    dp[i] = Math.max(dp[i],dp[j]+1);
//                }
//                if(dp[i]>max)
//                    max=dp[i];
//            }
//            return max;
//        }
//
//        public List<List<Integer>> threeSum(int[] nums) {
//            Set<List<Integer>> sets = new HashSet<>();
//            int l = nums.length;
//
//            Set<Integer> set = new HashSet<>();
//            for(int i=0;i<l;i++){
//                for(int j=i+1;j<l;j++){
//                    if(set.contains(-(nums[i] + nums[j]))){
//                        List<Integer> sortedSet1 = new ArrayList<>();
//                        sortedSet1.add(nums[i]);
//                        sortedSet1.add(nums[j]);
//                        sortedSet1.add(-(nums[i] + nums[j]));
//
//                        sets.add(new ArrayList<>(new PriorityQueue(sortedSet1)));
//                    }
//                }
//                set.add(nums[i]);
//            }
//            System.out.println(sets);
//            return new ArrayList<>(sets);
//        }
//
//
//        public boolean canPlaceFlowers(int[] flowerbed, int n) {
//            if(n==0)
//                return true;
//            int l = flowerbed.length;
//            if(l==1){
//                return flowerbed[0]==0;
//            }
//            if(flowerbed[0]==0 && flowerbed[1]==0) {
//                flowerbed[0]=1;
//                n--;
//            }
//            for(int i=1;i<l-1;i++){
//                if(flowerbed[i]==0 && flowerbed[i-1]==0 && flowerbed[i+1]==0){
//                    flowerbed[i]=1;
//                    i++;
//                    n--;
//                }
//            }
//            if(flowerbed[l-1]==0 && flowerbed[l-2]==0)
//                n--;
//            return n <= 0;
//        }
//
//
//        public int findMin(int[] nums) {
//            int n = nums.length;
//            if(nums[0]<=nums[n-1])
//                return nums[0];
//            if(nums.length==2)
//                Math.min(nums[1],nums[0]);
//            int left = 0, right=n-1,mid=(left+right)/2;
//            while (left!=right){
//                System.out.println(left);
//                System.out.println(right);
//                System.out.println(mid);
//                if(nums[mid]<nums[left] && nums[mid]<nums[right])
//                    return nums[mid];
//                if(nums[left]<nums[right]){
//                    right=mid;
//                }else{
//                    left=mid;
//                }
//                mid=(left+right)/2;
//
//            }
//            return nums[mid];
//        }
//
//
//        public int longestValidParentheses(String s) {
//
//            int maxL=0;
//            int count =0;
//            char[] chars = s.toCharArray();
//            Stack<Character> stack = new Stack<>();
//            for(char a: chars){
//                if(a == ')'){
//                    if(stack.empty() || stack.pop() ==')'){
//                        if(count>maxL)
//                            maxL=count;
//                        count=0;
//                    }else{
//                        count++;
//                    }
//                }
//                else{
//                    stack.push(a);
//                    count++;
//                }
//            }
//            if(!stack.empty()){
//                count -= stack.size();
//            }
//            if(count>maxL)
//                maxL=count;
//            return maxL;
//        }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    }
//
//}