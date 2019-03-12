package ru.roman.certification.cycle;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
class ForEachExample {

    public static void main(String[] args) {

        var a = new Integer[]{1, 2, 3};
        for (int i : a) {
        }
    }
}

class Graph {
    final int edges[][];

    Graph(int[][] edges) {
        this.edges = edges;
    }

    public Graph loseEdges(int i, int j) {
        int n = edges.length;
        int[][] newedges = new int[n][];
        for (int k = 0; k < n; ++k) {
            edgelist:
            {
                int z;
                search:
                {
                    if (k == i) {
                        for (z = 0; z < edges[k].length; ++z) {
                            if (edges[k][z] == j) break search;
                        }
                    } else if (k == j) {
                        for (z = 0; z < edges[k].length; ++z) {
                            if (edges[k][z] == i) break search;
                        }
                    }

                    // No edge to be deleted; share this list.
                    newedges[k] = edges[k];
                    break edgelist;
                } //search

                // Copy the list, omitting the edge at position z.
                int m = edges[k].length - 1;
                int ne[] = new int[m];
                System.arraycopy(edges[k], 0, ne, 0, z);
                System.arraycopy(edges[k], z + 1, ne, z, m - z);
                newedges[k] = ne;
            } //edgelist
        }
        return new Graph(newedges);
    }
}

class PseudoCode {
    public void loseEdges() {

        baraboo:
        {
            for (int k = 0; k < 10; ++k) {
                edgelist:
                {
                    int z = k;
                    search:
                    {
                        if (true) {
                            for (; ; ) {
                                break search;
                            }
                        } else if (z == 1) {
                            for (; ; ) {
                                break baraboo;
                            }
                        }

                        z++;
                        break edgelist;
                    } //search

                    int m = k + 2;
                } //edgelist
            }
        } //baraboo
    }

    void fafa() {
        http://my.domain/index.html
        papa:
        List.of(1, 2);
        papan:
        papa:
        {
            mala:
            {
                //break http;             // illegal, undefined lable
                if (true) break papan;
                if (true) break papa;
                System.out.println("after break");
            }
            System.out.println("after mala");
        }
        System.out.println("after papa & papan");   // покажет только это
    }

    public static void main(String[] args) {

        new PseudoCode().fafa();
    }
}