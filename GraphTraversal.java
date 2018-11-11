package utd.ds.assign4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphTraversal {

	public static List<String> visitedVerticeslist = new ArrayList<>();
	public static List<String> startVertex = new ArrayList<>();
	public static Queue<String> q = new LinkedList<>();


	public static void main(String[] args) {


		Map<String,List<String>> adjMap = new HashMap<>();
		List<String> list = new ArrayList<>();

		list = Arrays.asList("b,h,c".split(","));
		adjMap.put("a", list);

		list = new ArrayList<>();
		list = Arrays.asList("a,e".split(","));
		adjMap.put("b", list);

		list = new ArrayList<>();
		list = Arrays.asList("a,d,f".split(","));
		adjMap.put("c", list);

		list = new ArrayList<>();
		list = Arrays.asList("c,f,j,g,e".split(","));
		adjMap.put("d", list);

		list = new ArrayList<>();
		list = Arrays.asList("b,d,g".split(","));
		adjMap.put("e", list);

		list = new ArrayList<>();
		list = Arrays.asList("c,d,j".split(","));
		adjMap.put("f", list);

		list = new ArrayList<>();
		list = Arrays.asList("h,e,d,i".split(","));
		adjMap.put("g", list);

		list = new ArrayList<>();
		list = Arrays.asList("a,g".split(","));
		adjMap.put("h", list);

		list = new ArrayList<>();
		list = Arrays.asList("j,g,i".split(","));
		adjMap.put("i", list);

		list = new ArrayList<>();
		list = Arrays.asList("f,d,i".split(","));
		adjMap.put("j", list);

		/*list = new ArrayList<>();
		list = Arrays.asList("l".split(","));
		adjMap.put("k", list);

		list = new ArrayList<>();
		list = Arrays.asList("k".split(","));
		adjMap.put("l", list);*/

		System.out.println("Initial adjacency list");
		adjMap.forEach((k,v) -> {
			System.out.println(k+"->"+v);
		});
		System.out.println();
		System.out.println("BFS traversal");

		bfstraversal(adjMap);

		visitedVerticeslist = new ArrayList<>();

		System.out.println();
		System.out.println();
		System.out.println("DFS traversal");

		for(String str : startVertex) {
			System.out.println();
			System.out.println("start vertex : "+str);
			visitedVerticeslist.add(str);
			dfstraversal(adjMap.get(str), adjMap);
		}
	}

	public static void bfstraversal(Map<String, List<String>> adjMap) {

		for(Map.Entry<String, List<String>> mapitr : adjMap.entrySet()) {

			if(!visitedVerticeslist.contains(mapitr.getKey())) {
				System.out.println();
				System.out.println("start vertex : "+mapitr.getKey());
				startVertex.add(mapitr.getKey());
				visitedVerticeslist.add(mapitr.getKey());

				for(String s : adjMap.get(mapitr.getKey())) {
					q.add(s);
				}

				while(q.size() > 0) {
					String p = q.poll();
					System.out.print(p+" ");
					visitedVerticeslist.add(p);
					for(String s : adjMap.get(p)) {
						if(!visitedVerticeslist.contains(s) && !q.contains(s)) {
							q.add(s);
						}
					}
				}
			}
		}
	}

	public static void dfstraversal(List<String> list, Map<String, List<String>> map) {
		for(String vertex : list) {
			if(!visitedVerticeslist.contains(vertex)) {
				visitedVerticeslist.add(vertex);
				System.out.print(vertex+" ");
				dfstraversal(map.get(vertex), map);
			}			
		}
	}
}
