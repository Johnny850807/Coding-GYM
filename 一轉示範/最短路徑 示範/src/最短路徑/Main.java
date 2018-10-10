package 最短路徑;

import java.util.List;
import java.util.Scanner;

import 最短路徑.ShortestPathAlgorithm.Output;

public class Main {
	public static void main(String[] argv){
		Scanner in = new Scanner(System.in);
		int nSites = in.nextInt();
		Graph graph = new Graph(nSites);
		BijectiveHashMap<String, Integer> siteNameToId = new BijectiveHashMap<>();

		in.nextLine();
		for (int i = 0; i < nSites; i ++)
			siteNameToId.put(in.nextLine(), i);
		
		String nextLine;
		int targetSite1Id = 0;
		int targetSite2Id = 0;
		
		while((nextLine = in.nextLine()) != null)
		{
			String[] splits = nextLine.split(" "); // (site1 site2 distance | ASK: site1 site2)
			if (splits[0].equals("ASK:"))
			{
				targetSite1Id = siteNameToId.getValue(splits[1]);
				targetSite2Id = siteNameToId.getValue(splits[2]);
				break;
			}
			int site1Id = siteNameToId.getValue(splits[0]);
			int site2Id = siteNameToId.getValue(splits[1]);
			int distance = Integer.parseInt(splits[2]);
			graph.addWeight(site1Id, site2Id, distance);
		}
		
		ShortestPathAlgorithm spa = new DijkstraAlgorithm();
		Output output = spa.getShortestPath(graph, targetSite1Id, targetSite2Id);
		List<Integer> path = output.getPath();
		System.out.print(siteNameToId.getKey(path.get(0)));
		for (int i = 1; i < path.size(); i ++)
			System.out.print("-> " + siteNameToId.getKey(path.get(i)) + " ");
		System.out.println(output.getSumWeights());
	}
}
