//package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static class Task {
        boolean insertVector(int[] base, int vector) {
            for (int i = 0; i < 5; i++) {
                if ((vector & (1 << i)) == 0) continue;
                if ((base[i] & (1 << i)) == 0) {
                    base[i] = vector;
                    for (int j = i + 1; j < 5; j++) if (base[j] > 0 && (base[i] & (1 << j)) != 0) {
                        base[i] ^= base[j];
                    }
                    for (int j = i - 1; j >= 0; j--) if ((base[j] & (1 << i)) != 0) {
                        base[j] ^= base[i];
                    }
                    return true;
                }
                vector ^= base[i];
            }
            return false;
        }

        public class ArrayHash {
            int[] array;

            public ArrayHash(int[] array) {
                this.array = Arrays.copyOf(array, array.length);
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                ArrayHash arrayHash = (ArrayHash) o;
                return Arrays.equals(array, arrayHash.array);
            }

            @Override
            public int hashCode() {
                return Arrays.hashCode(array);
            }
        }

        public class DisjointSet {
            int[] arr;
            public DisjointSet(int n) {
                arr = new int[n];
                Arrays.fill(arr, -1);
            }
            int find(int x) {
                if (arr[x] < 0) return x;
                return arr[x] = find(arr[x]);
            }
            boolean union(int a, int b) {
                int ra = find(a), rb = find(b);
                if (ra == rb) return false;
                arr[ra] = rb;
                return true;
            }
        }

        public class Pair {
            int a, b;
            public Pair(int a, int b) {
                this.a = a;
                this.b = b;
            }
        }

        public class Triple {
            int a, b, c;
            public Triple(int a, int b, int c) {
                this.a = a;
                this.b = b;
                this.c = c;
            }
            public Triple(int[] z) {
                this.a = z[0];
                this.b = z[1];
                this.c = z[2];
            }
        }
        int S = 374;

        int[] xorValues;
        int[] root;
        int[] parent;
        int[][] inputEdges;
        int[][] dpVal;
        boolean[] off;
        List<Triple> additionalEdges;
        List<Pair>[] treeEdges;
        List<Integer>[] treeBasis;
        int[] treeBasisIndex;
        Map<ArrayHash, Integer> basisToIndex;
        List<ArrayHash> indexToBasis;
        int[][] basisTransition = new int[S][S];

        void dfs(int u, int p, int r, int val) {
            root[u] = r;
            parent[u] = p;
            xorValues[u] = val;
            for (Pair v: treeEdges[u]) if (v.a != p) {
                dfs(v.a, u, r, val ^ v.b);
            }
        }
        int mod = 1_000_000_007;
        int add(int a, int b) {
            int c = a + b;
            if (c >= mod) return c - mod;
            return c;
        }

        int getIndexOfBasis(int[] basis) {
            ArrayHash ar = new ArrayHash(basis);
            if (!basisToIndex.containsKey(ar)) {
                basisToIndex.put(ar, basisToIndex.size());
                indexToBasis.add(ar);
            }
            if (basisToIndex.size() > S) throw new RuntimeException();
            return basisToIndex.get(ar);
        }

        int merge(int basisIndex1, int basisIndex2) {
            if (basisTransition[basisIndex1][basisIndex2] == -2) {
                int[] basis1 = Arrays.copyOf(indexToBasis.get(basisIndex1).array, 5);
                int[] basis2 = Arrays.copyOf(indexToBasis.get(basisIndex2).array, 5);
                boolean valid = true;
                for (int b : basis2) {
                    if (b != 0) {
                        if (!insertVector(basis1, b)) {
                            valid = false;
                        }
                    }
                }
                if (valid) {
                    basisTransition[basisIndex1][basisIndex2] = basisTransition[basisIndex2][basisIndex1] = getIndexOfBasis(basis1);
                } else {
                    basisTransition[basisIndex1][basisIndex2] = basisTransition[basisIndex2][basisIndex1] = -1;
                }
            }
            return basisTransition[basisIndex1][basisIndex2];
        }

        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            for (int i = 0; i < S; i++) {
                Arrays.fill(basisTransition[i], -2);
            }
            basisToIndex = new HashMap<>();
            indexToBasis = new ArrayList<>();
            int n = sc.nextInt();
            int m = sc.nextInt();
            xorValues = new int[n];
            root = new int[n];
            parent = new int[n];
            off = new boolean[n];
            Arrays.fill(off, true);
            treeEdges = new List[n];
            additionalEdges = new ArrayList<>();
            treeBasis = new List[n];
            treeBasisIndex = new int[n];
            getIndexOfBasis(new int[5]);
            DisjointSet djs = new DisjointSet(n);
            for (int i = 0; i < n; i++) {
                treeEdges[i] = new ArrayList<>();
                treeBasis[i] = new ArrayList<>();
            }
            inputEdges = new int[m][3];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 3; j++) {
                    inputEdges[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < m; i++) {
                inputEdges[i][0]--;
                inputEdges[i][1]--;
                if (inputEdges[i][0] == 0 || inputEdges[i][1] == 0) {
                    djs.union(inputEdges[i][0], inputEdges[i][1]);
                    treeEdges[inputEdges[i][0]].add(new Pair(inputEdges[i][1], inputEdges[i][2]));
                    treeEdges[inputEdges[i][1]].add(new Pair(inputEdges[i][0], inputEdges[i][2]));
                }
            }
            for (int i = 0; i < m; i++) {
                if (inputEdges[i][0] != 0 && inputEdges[i][1] != 0) {
                    if (djs.union(inputEdges[i][0], inputEdges[i][1])) {
                        treeEdges[inputEdges[i][0]].add(new Pair(inputEdges[i][1], inputEdges[i][2]));
                        treeEdges[inputEdges[i][1]].add(new Pair(inputEdges[i][0], inputEdges[i][2]));
                    } else {
                        additionalEdges.add(new Triple(inputEdges[i]));
                    }
                }
            }
            for (Pair p: treeEdges[0]) {
                off[p.a] = false;
                dfs(p.a, 0, p.a, p.b);
            }
            List<Triple> pairedTrees = new ArrayList<>();

            for (Triple tri: additionalEdges) {
                int a = tri.a;
                int b = tri.b;
                if (root[a] != root[b]) {
                    if (a != root[a] || b != root[b]) throw new RuntimeException();
                    pairedTrees.add(tri);
                    // across
                } else {
                    int cycle = tri.c ^ xorValues[a] ^ xorValues[b];
                    treeBasis[root[a]].add(cycle);
                }
            }
            List<List<Integer>> choicesForTree = new ArrayList<>();
            for (int i = 1; i < n; i++) if (root[i] == i) {
                int[] basis = new int[5];
                for (int cycle: treeBasis[i]) {
                    if (!insertVector(basis, cycle)) {
                        off[i] = true;
                    }
                }
                if (!off[i]) {
                    treeBasisIndex[i] = getIndexOfBasis(basis);
                }
            }
            for (Triple p: pairedTrees) {
                if (off[p.a] || off[p.b]) {
                    off[p.a] = off[p.b] = true;
                    continue;
                }
                off[p.a] = true;
                off[p.b] = true;
                int nr;
                if ((nr = merge(treeBasisIndex[p.a], treeBasisIndex[p.b])) != -1) {
                    List<Integer> choices = new ArrayList<>();
                    int[] basis = Arrays.copyOf(indexToBasis.get(nr).array, 5);
                    choices.add(nr);
                    choices.add(nr);
                    if (insertVector(basis, p.c ^ xorValues[p.a] ^ xorValues[p.b])) {
                        choices.add(getIndexOfBasis(basis));
                    }
                    choicesForTree.add(choices);
                }
            }
            for (int i = 1; i < n; i++) if (root[i] == i && !off[i]) {
                List<Integer> choice = new ArrayList<>();
                choice.add(treeBasisIndex[i]);
                choicesForTree.add(choice);
            }
            dpVal = new int[2][S]; // \sum_{i=0}^5 {5 \choose i}_2
            dpVal[0][0] = 1;
            int cur = 0, next = 1;
            for (List<Integer> choices: choicesForTree) {
                System.arraycopy(dpVal[cur], 0, dpVal[next], 0, S);
                for (int choice: choices) {
                    for (int i = 0; i < S; i++) if (dpVal[cur][i] > 0) {
                        int nr;
                        if ((nr = merge(i, choice)) != -1) {
                            dpVal[next][nr] = add(dpVal[next][nr], dpVal[cur][i]);
                        }
                    }
                }
                cur ^= 1;
                next ^= 1;
            }
            int total = 0;
            for (int i = 0; i < S; i++) total = add(total, dpVal[cur][i]);
            pw.println(total);
        }
    }
    static long TIME_START, TIME_END;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("input"));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
//        PrintWriter pw = new PrintWriter(new FileOutputStream("input"));

        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        TIME_START = System.currentTimeMillis();
        Task t = new Task();
        t.solve(sc, pw);
        TIME_END = System.currentTimeMillis();
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        pw.close();
        System.err.println("Memory increased: " + (usedMemoryAfter - usedMemoryBefore) / 1000000);
        System.err.println("Time used: " + (TIME_END - TIME_START) + ".");
    }
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;
        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }
        public Scanner(FileReader s) throws FileNotFoundException {
            br = new BufferedReader(s);
        }
        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        public String nextLine() throws IOException {
            return br.readLine();
        }
        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}