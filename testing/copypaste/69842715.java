import java.util.*;

import java.io.*;
public class cf {
  public static void main(String[] args) throws IOException,InterruptedException{
	Scanner sc =new Scanner(System.in);
	PrintWriter pw = new PrintWriter(System.out);
	int n =sc.nextInt();
	long [] curr =new long [n];
	long [] temp =new long[n];
	long [] prefixSum=new long[n+1];
	for (int i =0;i<n;++i)
		curr[i]=sc.nextLong();
	for (int i =1;i<=n;++i) {
		temp[i-1]=sc.nextLong();
		prefixSum[i]=temp[i-1]+prefixSum[i-1];
	}
	PriorityQueue<Long> pq =new PriorityQueue<Long>();
	for (int i =0;i<n;++i) {
		long j=0;
		pq.add(prefixSum[i]+curr[i]);
		while (!pq.isEmpty()&&pq.peek()<=prefixSum[i+1])
			j+=(pq.poll()-prefixSum[i]);
		j+=(temp[i]*pq.size());
		pw.print(j+" ");
	}
	pw.flush();
	}
  static class Scanner {
		StringTokenizer stringTokenizer;
		BufferedReader bfBufferedReader;
		public Scanner(InputStream system) {
			bfBufferedReader=new BufferedReader(new InputStreamReader( system));
		}
		 public Scanner(String file) throws Exception {
	            bfBufferedReader = new BufferedReader(new FileReader( file));
	        }			 
	        public String next() throws IOException {
	            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens())
	                stringTokenizer = new StringTokenizer( bfBufferedReader.readLine());
	            return stringTokenizer.nextToken();
	        }
	 
	        public String nextLine() throws IOException {
	            return bfBufferedReader.readLine();
	        }
	 
	        public int nextInt() throws IOException {
	            return Integer.parseInt(next());
	        }
	 
	        public double nextDouble() throws IOException {
	            return Double.parseDouble(next());
	        }
	 
	        public char nextChar() throws IOException {
	            return next().charAt(0);
	        }
	 
	        public Long nextLong() throws IOException {
	            return Long.parseLong(next());
	        }
	 
	        public boolean ready() throws IOException {
	            return bfBufferedReader.ready();
	        }
	 
	        public void waitForInput() throws InterruptedException {
	            Thread.sleep(3000);
	        }
  }
  }