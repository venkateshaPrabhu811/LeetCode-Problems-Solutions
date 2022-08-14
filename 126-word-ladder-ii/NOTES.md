for (int i = 0; i < chs.length; i++) {
for (char c = 'a'; c <= 'z'; c++) {
if (chs[i] == c) continue;
char t = chs[i];
chs[i] = c;
String target = String.valueOf(chs);
if (dict.contains(target)) result.add(target);
chs[i] = t;
}
}
return result;
}
private void dfs(String curWord, String endWord, HashMap<String, List<String>> graph, List<String> path, List<List<String>> result) {
path.add(curWord);
if (curWord.equals(endWord)) result.add(new ArrayList<String>(path));
else if (graph.containsKey(curWord)) {
for (String nextWord : graph.get(curWord)) {
dfs(nextWord, endWord, graph, path, result);
}
}
​
path.remove(path.size()-1);
}
}