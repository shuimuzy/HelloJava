package com.samples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.prefs.Preferences;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class JavaClassicalSamples {

	public static void main(String[] args) {

/*
		//1. 获取环境变量

		System.getenv("PATH");  
		System.getenv("JAVA_HOME");  

		//2. 获取系统属性

		System.getProperty("pencil color");  // 得到属性值  

		System.getProperty("java.specification.version");  // 得到Java版本号  
		Properties p = System.getProperties();  // 得到所有属性值  
		//p.list(System.out);  

		//3. StringTokenizer

		// 能够同时识别, 和 |  
		StringTokenizer st = new StringTokenizer("Hello, World|of|Java", ", |");  
		while (st.hasMoreElements()) {  
		    st.nextToken();  
		}  
		  
		// 把分隔符视为token  
		StringTokenizer st1 = new StringTokenizer("Hello, World|of|Java", ", |",  true);  

		//4. StringBuffer(同步)和StringBuilder(非同步)

		StringBuffer sb = new StringBuffer();  
		sb.append("Hello");  
		sb.append("World");  
		sb.toString();  
		//new StringBuffer(a).reverse();   // 反转字符串  

		//5. 数字

		// 数字与对象之间互相转换 - Integer转int  
		int int1 = Integer.parseInt("123");  
		  
		// 浮点数的舍入    
		long int2 = Math.round(123.123);  
		  
		// 数字格式化  
		//NumberFormat  
		  
		 // 整数 -> 二进制字符串  toBinaryString() 或valueOf()  
		   
		 // 整数 -> 八进制字符串  toOctalString()  
		   
		 // 整数 -> 十六进制字符串  toHexString()  
		   
		 // 数字格式化为罗马数字  RomanNumberFormat()  
		   
		 // 随机数  
		 Random r = new Random();  
		 r.nextDouble();  
		 r.nextInt();  

		//6. 日期和时间

		// 查看当前日期  
		Date today = new Date();  
		Calendar.getInstance().getTime();  
		  
		// 格式化默认区域日期输出  
		DateFormat df = DateFormat.getInstance();  
		df.format(today);  
		  
		// 格式化制定区域日期输出        
		 DateFormat df_cn = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);  
		 String now = df_cn.format(today);  
		   
		 // 按要求格式打印日期  
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
		 sdf.format(today);  
		   
		 // 设置具体日期  
		 GregorianCalendar d1 = new GregorianCalendar(2009, 05, 06);  // 6月6日  
		 GregorianCalendar d2 = new GregorianCalendar();  // 今天  
		 Calendar d3 = Calendar.getInstance();  // 今天  
		 d1.getTime();  // Calendar或GregorianCalendar转成Date格式  
		 d3.set(Calendar.YEAR, 1999);  
		 d3.set(Calendar.MONTH, Calendar.APRIL);  
		 d3.set(Calendar.DAY_OF_MONTH, 12);  
		   
		 // 字符串转日期  
		 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
		 //Date now = sdf1.parse(String);  
		   
		 // 日期加减  
		 Date now1 = new Date();  
		 long t = now1.getTime();  
		 t += 700*24*60*60*1000;  
		 Date then = new Date(t);  
		   
		 Calendar now2 = Calendar.getInstance();  
		 now2.add(Calendar.YEAR, -2);  
		   
		 // 计算日期间隔(转换成long来计算)  today.getTime() - old.getTime();  
		   
		 // 比较日期  
		 //Date 类型，就使用equals(), before(), after()来计算  
		 //long类型，就使用==, <, >来计算  
		   
		 // 第几日  
		 //使用 Calendar的get()方法  
		 Calendar c = Calendar.getInstance();  
		 c.get(Calendar.YEAR);   
		   
		 // 记录耗时  
		 long start = System.currentTimeMillis();  
		 long end = System.currentTimeMillis();  
		 long elapsed = end - start;  
		 System.nanoTime();  //毫秒  
		   
		 // 长整形转换成秒  
		 Double.toString(t/1000D);  


		//7. 结构化数据

		// 数组拷贝  	System.arrayCopy(oldArray, 0, newArray, 0, oldArray.length);  
		String[] str1 = new String[3];
		String[] str2 = new String[]{"a", "c", "b"};	
		Arrays.sort(str2);
		//System.out.println(str2[0]);
		  
		// ArrayList 
		
		add(Object o)  // 在末尾添加给定元素  
		add(int i, Object o)  // 在指定位置插入给定元素  
		clear()  // 从集合中删除全部元素  
		Contains(Object o)  // 如果Vector包含给定元素，返回真值  
		get(int i)  // 返回 指定位置的对象句柄  
		 indexOf(Object o)  // 如果找到给定对象，则返回其索引值；否则，返回-1  
		 remove(Object o)  // 根据引用删除对象  
		 remove(int i)  // 根据 位置删除对象  
		 toArray()  // 返回包含集合对象的数组  
		  
		ArrayList<String> al = new ArrayList<String>(3);
		al.add("a");
		al.add("b");
		al.add("d");
		al.add(1, "c");
		//System.out.println(al);
		boolean bl = al.contains("c");
		//System.out.println(Boolean.toString(bl));
		String a = al.get(2);
		int it1 = al.indexOf(a);
		al.remove(3);
		//System.out.println(al);
		 
		 // Iterator  
		 List<String> list = new ArrayList<String>();  
		 list = al;
		 Collections.sort(list); //排序
		 Iterator<String> it = list.iterator();  
		 while (it.hasNext()){
			 String o = it.next();  
			 //System.out.println(o);
		 }  
	   
		 // 链表  
		 LinkedList<String> list1 = new LinkedList<String>();  
		 list1.add("1");
		 list1.add("2");
		 list1.add("3");
		 
		 ListIterator<String> it2 = list1.listIterator();  
		 while (it2.hasNext()) {
			 String s1 = it2.next(); 
			 //System.out.println(s1);
		 } 

		 	   
		 // HashMap  
		 HashMap<String, String> hm = new HashMap<String, String>();  

		 hm.put("No1", "Hexinyu");  
		 hm.put("No2", "Sean");  
		 hm.get("No2");  // 通过key得到value  
		 // 方法1: 获取全部键值    
		 Iterator<String> it3 = hm.values().iterator();   
		 while (it3.hasNext()) {  
		     String myValue = it3.next();  
		     //System.out.println(myValue); 
		 }  
		 // 方法2: 获取全部键值        
		 for (String key : hm.keySet()) {  
		     String myKey = key;  
		     String myValue = hm.get(myKey);  
		 }  
			   
		 // Preferences - 与系统相关的用户设置，类似名-值对  
		 Preferences prefs = Preferences.userNodeForPackage(ArrayDemo.class);  
		 String text = prefs.get("textFontName", "lucida-bright");  
		 String display = prefs.get("displayFontName", "lucida-balckletter");  
		 System.out.println(text);  
		 System.out.println(display);  
		 // 用户设置了新值，存储回去       
		 prefs.put("textFontName", "new-bright");  
		 prefs.put("displayFontName", "new-balckletter");  
		   
		 // Properties - 类似名-值对，key和value之间，可以用"="，":"或空格分隔，用"#" 和"!"注释  
		 InputStream in = MediationServer.class.getClassLoader().getResourceAsStream("msconfig.properties");  
		 Properties prop = new Properties();  
		 prop.load(in);  
		 in.close();  
		 prop.setProperty(key, value);  
		 prop.getProperty(key);  

	   
		 // 排序  
		 1. 数组：Arrays.sort(strings);  
		 2. List：Collections.sort(list);  
		 3. 自定义类：class SubComp implements Comparator  
		     然 后使用Arrays.sort(strings, new SubComp())  
		      
		 // 两个接口  
		 1. java.lang.Comparable: 提供对象的自然排序，内置于类中  
		    int compareTo(Object o);  
		     boolean equals(Object o2);  
		 2. java.util.Comparator: 提供特定的比较方法  
		    int compare(Object o1, Object o2)  
		      
		 // 避免重复排序，可以使用TreeMap  
		 TreeMap sorted = new TreeMap(unsortedHashMap);  
		   
		 // 排除重复元素  
		 Hashset hs = new HashSet();  
		   
		 // 搜索对象  
		 binarySearch(): 快 速查询 - Arrays, Collections  
		 contains(): 线型搜 索 - ArrayList, HashSet, Hashtable, linkedList, Properties, Vector  
		 containsKey(): 检 查集合对象是否包含给定 - HashMap, Hashtable, Properties, TreeMap  
		 containsValue(): 主 键(或给定值) - HashMap, Hashtable, Properties, TreeMap  
		 indexOf(): 若 找到给定对象，返回其位置 - ArrayList, linkedList, List, Stack, Vector  
		 search(): 线 型搜素 - Stack  
		   
		 // 集合转数组   toArray();  
		   
		 // 集合总结  
		 Collection: Set - HashSet, TreeSet  
		 Collection: List - ArrayList, Vector, LinkedList  
		 Map: HashMap, HashTable, TreeMap  

		//8. 泛型与foreach

		// 泛型  
		List<String> myList = new ArrayList<String>();  
		myList.add("a");
		myList.add("b");
		// foreach  
		for (String s : myList) {  
		    System.out.println("");
		   
		}  

		//9. 面向对象

		// toString()格式化  
		public class ToStringWith {  
		    int x, y;  
		    public ToStringWith(int anX, int aY) {  
		        x = anX;  
		        y = aY;  
		    }  
		    public String toString() {  
		        return "ToStringWith[" + x + "," + y + "]";  
		     }  
		     public static void main(String[] args) {  
		         System.out.println(new ToStringWith(43, 78));  
		     }  
		 } 
 
				   
		 // 覆盖equals方法  
		 public boolean equals(Object o) {  
		     if (o == this)  // 优化  
		         return true;  
		     if (!(o instanceof EqualsDemo))  // 可投射到这个类  
		         return false;  
		     EqualsDemo other = (EqualsDemo)o;  // 类型转换  
		     if (int1 != other.int1)  // 按字段比较  
		         return false;  
		     if (!obj1.equals(other.obj1))  
		         return false;  
		     return true;  
		 }  
		   
		 // 覆盖hashcode方法  
		 private volatile int hashCode = 0;  //延迟初始化  
		 public int hashCode() {  
		     if (hashCode == 0) {  
		         int result = 17;  
		         result = 37 * result + areaCode;  
		     }  
		     return hashCode;  
		 }  
		   
		 // Clone方法  
		 要 克隆对象，必须先做两步: 1. 覆盖对象的clone()方法; 2. 实现空的Cloneable接口  
		 public class Clone1 implements Cloneable {  
		     public Object clone() {  
		         return super.clone();  
		     }  
		 }  
		   
		 // Finalize方法  
		 Object f = new Object() {  
		     public void finalize() {  
		         System.out.println("Running finalize()");  
		     }  
		 };        
		 Runtime.getRuntime().addShutdownHook(new Thread() {  
		     public void run() {  
		         System.out.println("Running Shutdown Hook");  
		     }  
		 });  
		 在 调用System.exit(0);的时候，这两个方法将被执行  
		   
		 // Singleton模式  
		 // 实现1  
		 public class MySingleton() {  
		     public static final MySingleton INSTANCE = new MySingleton();  
		     private MySingleton() {}  
		 }  
		 // 实现2  
		 public class MySingleton() {  
		     public static MySingleton instance = new MySingleton();  
		     private MySingleton() {}  
		     public static MySingleton getInstance() {  
		         return instance;  
		     }  
		 }  
		   
		 // 自定义异常  
		 Exception: 编 译时检查  
		 RuntimeException: 运行时检查  
		 public class MyException extends RuntimeException {  
		     public MyException() {  
		         super();  
		     }  
		     public MyException(String msg) {  
		         super(msg);  
		     }  
		 }  

		
		//10. 输入和输出

		// Stream, Reader, Writer  
		//Stream: 处 理字节流  
		//Reader/Writer: 处理字符，通用Unicode  
		  
		// 从标准输入设备读数据  
		//1. 用System.in的BufferedInputStream()读取字节  
		    int b;
			try {
				b = System.in.read();
				System.out.println("Read data: " + (char)b);  // 强 制转换为字符  
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
						
		      
		//2. BufferedReader 读取文本 , 如果从Stream转成Reader，使用 InputStreamReader类  
		     BufferedReader is = new BufferedReader(new InputStreamReader(System.in));  
		       String inputLine;  
		       try {
				while ((inputLine = is.readLine()) != null) {  
				       System.out.println(inputLine);  
				       int val = Integer.parseInt(inputLine);  // 如果inputLine为整数  
				       
				 }
				is.close();  
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

		       
	       
		 // 向标准输出设备写数据  
		 //1. 用System.out的println()打印数据  
		 //2. 用PrintWriter打印  
		     PrintWriter pw = new PrintWriter(System.out);  
		       pw.println("The answer is " + myAnswer + " at this time.");  
		       
		 // Formatter类  
		// 格 式化打印内容  
		 Formatter fmtr = new Formatter();  
		 fmtr.format("%1$04d - the year of %2$f", 1951, Math.PI);  
		 //或 者System.out.printf();或者System.out.format();        
		   
		 // 原始扫描  
		 void doFile(Reader is) {  
		     int c;  
		     while ((c = is.read()) != -1) {  
		         System.out.println((char)c);  
		     }  
		 }    


		 // Scanner扫描 ,  Scanner 可以读取File, InputStream, String, Readable  
		 try {  
		     Scanner scan = new Scanner(new File("Files/a.txt"));  
		     while (scan.hasNext()) {  
		         String s = scan.next();  
		         System.out.println(s);
		     }  
		     scan.close();
		     } catch (FileNotFoundException e) {  
		         e.printStackTrace();  
		     }  
		 
		   
		 // 读取文件  BufferedReader
		 BufferedReader is;
		try {
			is = new BufferedReader(new FileReader("Files/myFile.txt"));
			String str;
			while ((str = is.readLine()) != null) {
				System.out.println(str);
			}
		//写文件	 BufferedOutputStream
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Files/bytes.bat"));
			String tr = "abc";
			bos.write(tr.getBytes());
			is.close();
			bos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		   
		   		   
		 // 复制文件  BufferedInputStream, BufferedOutputStream
		 BufferedInputStream is1;
		try {
			is1 = new BufferedInputStream(new FileInputStream("Files/oldFile.txt"));
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream("Files/newFile.txt"));  
			 int b;  
			 while ((b = is1.read()) != -1) {  
			     os.write(b);  
			 }  
			 is1.close();  
			 os.close(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  
		 		   
		 // 文件读入字符串  
		 StringBuffer sb2 = new StringBuffer();  
		 char[] b = new char[8192];  
		 int n;  
		 // 读一个块，如果有字符，加入缓冲区  
		 BufferedReader is;
		try {
			is = new BufferedReader(new FileReader("Files/myFile.txt"));
			while ((n = is.read(b)) > 0) {  
			     sb2.append(b, 0, n);  
			 }
			System.out.println(sb2.toString()); 
			is.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		 
		 		   
		 // 重定向标准流  
		try {
		 String logfile = "error.log";  
		 System.setErr(new PrintStream(new FileOutputStream(logfile)));  
		   
		 // 读写不同字符集文本  
		 BufferedReader chinese = new BufferedReader(new InputStreamReader(new FileInputStream("chinese.txt"), "ISO8859_1"));  
		 PrintWriter standard = new PrintWriter(new OutputStreamWriter(new FileOutputStream("standard.txt"), "UTF-8"));  
		   
		 // 读取二进制数据  
		 DataOutputStream os = new DataOutputStream(new FileOutputStream("Files/a.txt"));  
		 int i = 1234;
		 double d = 1234.12;
		 os.writeInt(i);  
		 os.writeDouble(d);  
		 os.close();  
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		 // 从指定位置读数据  
		 RandomAccessFile raf = new RandomAccessFile(fileName, "r");  // r表示已 只读打开  
		 raf.seek(15);  // 从15开始读  
		 raf.readInt();  
		 raf.radLine();  
		 	   
		 // 串行化对象  
		 对象串 行化，必须实现Serializable接口  
		  // 保存 数据到磁盘  
		  ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FILENAME)));  
		  os.writeObject(serialObject);  
		  os.close();  
		  // 读出数据  
		  ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILENAME));  
		  is.readObject();  
		  is.close();  
	
		
		  // 读写Jar或Zip文档  
		  ZipFile zippy;
		try {
			zippy = new ZipFile("Files/test.zip");
		
		  Enumeration<? extends ZipEntry> all = zippy.entries();  // 枚举值列出所有文件清单  
		  while (all.hasMoreElements()) {  
		      ZipEntry entry = (ZipEntry)all.nextElement();  
		      if (entry.isDirectory())  
		          System.out.println("Directory: " + entry.getName());  
		      else {		    	 
		      // 读写文件  
		      FileOutputStream os = new FileOutputStream(entry.getName());  
		      InputStream is = zippy.getInputStream(entry);  
		      int n = 0;  
		      byte[] b = new byte[8092];  
		      while ((n = is.read(b)) > 0) {  
		          os.write(b, 0, n);  
		          
		      }  
		      is.close();  
	          os.close(); 
		      }   
		  } 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		   
		  // 读写gzip文档  
		
		  String FILENAME = "abc.txt";
		  FileInputStream fin;
		try {
			fin = new FileInputStream(FILENAME);
			GZIPInputStream gzis = new GZIPInputStream(fin);  
			InputStreamReader xover = new InputStreamReader(gzis);  
			BufferedReader is2 = new BufferedReader(xover);  
			String line;  
			while ((line = is2.readLine()) != null)  
				System.out.println("Read: " + line);  
			is2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
      
		//11. 目录和文件操作

		// 获取文件信息  
		exists(): 如 果文件存在，返回true  
		getCanonicalPath(): 获 取全名  
		getName(): 文件名  
		getParent(): 父 目录  
		canRead(): 如果文件可读，返回true  
		canWrite(): 如 果文件可写，返回true  
		lastModified(): 文 件更新时间  
		length(): 文件大小  
		 isFile(): 如 果是文件，返回true  
		 ifDirectory(): 如 果是目录，返回true  
		 要 调用文件的这些方法，必须  
		 File f = new File(fileName);  
		   
		
		 // 创建文件  
		 File f = new File("c:\\test\\mytest.txt");  
		 f.createNewFile();  // 创建mytest.txt文件到test目录下  
		   
		 // 修改文件名  
		 File f = new File("c:\\test\\mytest.txt");  
		 f.renameTo(new File("c:\\test\\google.txt"));  
		 //把 mytest.txt修改成google.txt  
		   
		 // 删除文件  
		 File f = new File("c:\\test\\mytest.txt");  
		 f.delete();  
		   
		 // 临时文件  
		 File f = new File("C:\\test");  // 指定一个文件夹  
		 // 在test文件夹中创建foo前缀，tmp后缀的临时文件  
		 File tmp = File.createTempFile("foo", "tmp", f);   
		 tmp.deleteOnExit();  // 在程序结束时删除该临时文件  
		   
		 // 更改文件属性  
		 //setReadOnly(): 设 置为只读  
		// setlastModified(): 设置最后更改时间  
		   
		
		 // 列出当前文件夹的文件列表  
		 String[] dir = new File(".").list();  
		 Arrays.sort(dir);  
		 for (int i = 0; i < dir.length; i++) {  
		     System.out.println(dir[i]);  
		 }  
		   
		 // 过滤文件列表  
		 class OnlyJava implements FilenameFilter {  
		     public boolean accept(File dir, String s) {  
		         if (s.endsWith(".java") || s.endsWith(".class") || s.endsWith(".jar"))  
		             return true;  
		         else
		        	 return false;
		             
		     }  
		 }  
		
			   
		 // 获取根目录  
		 File[] rootDir = File.listRoots();  
		 for (int i = 0; i < rootDir.length; i++) {  
		     System.out.println(rootDir[i]);  
		 }  
		   
		 // 创建新目录  
		 new File("/home/ian/bin").mkdir();  // 如果"/home/ian"存在，则可以创建bin目录  
		 new File("/home/ian/bin").mkdirs();  // 如果"/home/ian"不存在，会创建所有的目录  

		//12. 国际化和本地化

		// I18N资源  
		ResourceBundle rb = ResourceBundle.getBundle("Menus");  
		String label = rb.getString("exit.label");  
		// ResourceBundle相当于名值对，获取Menus按钮的区域属性  
		//Menus_cn.properties: 不 同区域的属性文件  
		  
		// 列出有效区域  
		Locale[] list2 = Locale.getAvailableLocales();  
		 
		 // 指定区域  
		 Locale cnLocale = Locale.CHINA;  
		   
		 // 设置默认区域  
		 Locale.setDefault(Locale.CHINA);  
		   
		 // 格式化消息  
		 public class MessageFormatDemo {  
		     static Object[] data = {  
		         new Date(),  
		         "myfile.txt",  
		         "could nto be opened"  
		     };  
		     public static void main(String[] args) {  
		         String result = MessageFormat.format("At {0,time} on {0,date}, {1} {2}.", data);  
		         System.out.println(result);  
		     }  
		 }  
		 //输 出: At 10:10:08 on 2009-6-18, myfile.txt could nto be opened. 
		 
		   
		 // 从资源文件中读消息  
		 Widgets.properties 在com.sean.cook.chap11下  
		 ResourceBundle rb = ResourceBundle.getBundle("com.sean.cook.chap11.Widgets");  
		 String propt = rb.getString("filedialogs.cantopen.string");  
		 String result = MessageFormat.format(rb.getString("filedialogs.cantopen.format"), data);  
*/
		
		 //13. 网络客户端
/*
		// 访问服务器  
		Socket socket;
		socket = new Socket("192.168.1.106", 8088);
		// todo something  
		socket.close();
			
		// 查找网络地址
		String addr = InetAddress.getByName(hostName).getHostAddress(); // 根据主机名得到IP地址  
		String hname = InetAddress.getByName(ipAddr).getHostName(); // 根据IP地址得到主机名  
		   
		// Socket读写文本数据  
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
		String remoteTime = in.readLine();  
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  
		out.print("send message to client \r\n");  
		out.flush();  
		
		 // Socket读写二进制数据  
		 DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));  
		 long remoteTime = (long)(in.readUnsignedByte() << 24);  
		 DataOutputStream out = new DataOutputStream(socket.getOutputStream(), true);  
		   
		 // Socket读写串行化数据  
		 ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));  
		 Object o = in.readObject();  
		 if (o instanceof Date) // 验证对象类型  
		 ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream(), true);  
		   
		 // UDP数据报  
		 private final static int PACKET_SIZE = 1024;  
		       
		 String host = "EV001B389673DE";  
		 InetAddress serverAddr = InetAddress.getByName(host);  
		 DatagramSocket socket = new DatagramSocket();  
		 byte[] buffer = new byte[PACKET_SIZE]; // 分配数据缓冲空间  
		 DatagramPacket packet = new DatagramPacket(buffer, PACKET_SIZE, serverAddr, 8080);  
		 packet.setLength(PACKET_SIZE-1); // 设置数据长度  
		 socket.send(packet);  
		 socket.receive(packet); // 接收数据  

		
		//14. 服务器端: Socket 

		// 创建ServerSocket  
		//ServerSocket serverSocket;  
		//Socket clientSocket;  
		
		 // 监听内部网  
		 public static final short PORT = 9999;  
		 public static final String INSIDE_HOST = "acmewidgets-inside"; // 网络接口名  
		 public static final int BACKLOG = 10; // 待发数  
		 serverSocket = new ServerSocket(PORT, BACKLOG, InetAddress.getByName(INSIDE_HOST));  
		   
		 // 返回相应对象  
		 ServerSocket serverSocket =  new ServerSocket(9999);;  
		 Socket clientSocket;  
		 BufferedReader in = null;  
		 PrintWriter out = null;  
		 while (true) {  
		     clientSocket = serverSocket.accept();  
		     in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "8859_1"));  
		     out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "8859_1"), true);  
		     String echoLine;  
		     while ((echoLine = in.readLine()) != null) {  
		         System.out.println("Read " + echoLine);  
		         out.print(echoLine + "\r\n");  
		     }  
		 }  
		 以 上例子返回字符串，如果返回二进制，则使用DataOutputStream；返回对象，使用ObjectOutputStream  
		   
		 // 处理多客户端  
		 需要 把接收数据的处理放入多线程中  
		 public class EchoServerThreaded {  
		     public static final int ECHOPORT = 7;  
		     public static final int NUM_THREADS = 4;  
		   
		     public static void main(String[] av) {  
		         new EchoServerThreaded(ECHOPORT, NUM_THREADS);  
		     }  
		   
		     public EchoServerThreaded2(int port, int numThreads) {  
		         ServerSocket servSock;  
		         Socket clientSocket;  
		         try {  
		             servSock = new ServerSocket(ECHOPORT);  
		         } catch(IOException e) {  
		             throw new RuntimeException("Could not create ServerSocket " + e);  
		         }  
		         for (int i = 0; i < numThreads; i++) {  
		             new Handler(servSock, i).start();  
		         }  
		     }  
		 }  
		 class Handler extends Thread {  
		     ServerSocket servSock;  
		     int threadNumber;  
		   
		     Handler(ServerSocket s, int i) {  
		         super();  
		         servSock = s;  
		         threadNumber = i;  
		         setName("Thread " + threadNumber);  
		     }  
		   
		     public void run() {  
		         while (true) {  
		             try {  
		                 System.out.println(getName() + " waiting");  
		                 Socket clientSocket;  
		                 synchronized (servSock) {  
		                     clientSocket = servSock.accept();  
		                 }  
		                 System.out.println(getName() + " starting, IP=" + clientSocket.getInetAddress());  
		                 BufferedReader is = new BufferedReader(new InputStreamReader(  
		                     clientSocket.getInputStream()));  
		                 PrintStream os = new PrintStream(clientSocket.getOutputStream(), true);  
		                 String line;  
		                 while ((line = is.readLine()) != null) {  
		                     os.print(line + "\r\n");  
		                     os.flush();  
		                 }  
		                 System.out.println(getName() + " ENDED ");  
		                 clientSocket.close();  
		             } catch (IOException ex) {  
		                 System.out.println(getName() + ": IO Error on socket " + ex);  
		                 return;  
		             }  
		         }  
		     }  
		 }  
		   
		 // 使用SSL和JSSE保护Web服务器  
		 SSLServerSocketFactory ssf = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault()；  
		 ServerSocket serverSocket = ssf.createServerSocket(8080);  
		   
		 // Log4j  
		  Level 级别: DEBUG < INFO < WARN < ERROR < FATAL < OFF  
		  Appender: 输 出信息  
		  ConsoleAppender: 输出控制台 System.out  
		    
		  // 找到网络接口  
		  Enumeration list = NetworkInterface.getNetworkInterfaces();  
		  while (list.hasMoreElements()) {  
		      NetworkInterface iface = (NetworkInterface)list.nextElement();  
		      System.out.println(iface.getDisplayName());  
		      Enumeration addrs = iface.getInetAddresses();  
		      while (addrs.hasMoreElements()) {  
		          InetAddress addr = (InetAddress)addrs.nextElement();  
		          System.out.println(addr);  
		      }  
		  }  
*/
/*
 * 		//15. Java Mail
		 
		// 发送Mail  
		protected String msgRecIp = "hxydream@163.com";  
		protected String msgSubject = "babytree";  
		protected String msgCc = "nobody@erewhon.com";  
		protected String msgBody = "test body";  
		protected Session session;  
		protected Message msg;  
		      
		public void doSend() {  
		     // 创建属性文件  
		     Properties props = new Properties();  
		     props.put("mail.smtp.host", "mailhost");  
		     // 创建Session对象  
		     session = Session.getDefaultInstance(props, null);  
		     session.setDebug(true);  
		     msg = new MimeMessage(session); // 创建邮件  
		     msg. setFrom(new InternetAddress("nobody@host.domain"));  
		     InternetAddress toAddr = new InternetAddress(msgRecIp);  
		     msg.addRecipient(Message.RecipientType.TO, toAddr);  
		     InternetAddress ccAddr = new InternetAddress(msgCc);  
		     msg.addRecipient(Message.RecipientType.CC, ccAddr);  
		     msg.setSubject(msgSubject);  
		     msg.setText(msgBody);   
		     Transport.send(msg);   
		 }  
		   
		 // 发送MIME邮件  
		 Multipart mp = new MimeMultipart();  
		 BodyPart textPart = new MimeBodyPart();  
		 textPart.setText(message_body);  // 设置类型"text/plain"  
		 BodyPart pixPart = new MimeBodyPart();  
		 pixPart.setContent(html_data, "text/html");  
		 mp.addBodyPart(textPart);  
		 mp.addBodyPart(pixPart);  
		 mesg.setContent(mp);  
		 Transport.send(mesg);  
		   
		 // 读Mail  
		 Store store = session.getStore(protocol);  
		 store.connect(host, user, password);  
		 Folder rf;  
		 rf = store.getFolder(root);  
		 rf = store.getDefaultFolder();  
		 rf.open(Folder.READ_WRITE);  

		//16. 数据库访问 

		// JDO  
		Properties p = new Properties();  
		p.load(new FileInputStream("jdo.properties"));  
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(p);  
		PersistenceManager pm = pmf.getPersistenceManager();  
		// 提交数据  
		pm.currentTransaction().begin();  
		if (o instanceof Collection) {  
		    pm.makePersistentAll((Collection) o);  
		 } else {  
		     pm.makePersistent(o);  
		 }  
		 pm.currentTransaction().commit();  
		 pm.close();  
		 // 取出数据  
		 Object[] data = new Object[3];  
		 pm.retrieveAll(data);  
		 for (int i = 0; i < data.length; i++) {  
		     System.out.println(data[i]);  
		 }  
		 pm.close();  
		   
		 // 数据操作  
		 Class clz = Class.forName("oracle.jdbc.driver.OracleDriver");  
		 String dbUrl = "jdbc:oracle:thin:@192.168.0.23:1521#:nms";  
		 Connection conn = DriverManager.getConnection(dbUrl, "su", "1234");  
		 Statement stmt = conn.createStatement();  
		 ResultSet rs = stmt.executeQuery("select * from pmtable");  
		 while (rs.next()) {  
		     String name = rs.getString(1);  
		     String otherName = rs.getString("name");  
		 }  
		   
		 // 使用PreparedStatement提高性能，除了查询，都使用executeUpdate执行操作   
		 PreparedStatement pstmt = conn.prepareStatement("select * from pmtable where name = ?");  
		 pstmt.setString(1, "sean");  
		 ResultSet rs = pstmt.executeQuery();  
		   
		 // 调用存储过程             
		 CallableStatement cs = conn.prepareCall("{ call ListDefunctUsers }");  
		 ResultSet rs = cs.executeQuery();  
		           
		 // 显示数据库表信息   
		 DatabaseMetaData meta = conn.getMetaData();  
		 meta.getDatabaseProductName();  
		 meta.getDatabaseProductVersion();  
		 meta.getDefaultTransactionIsolation();  

		    //17. XML
		    SAX: 在读取文档提取相应的标记事件(元素起始、元素结束、文档起始)
		    DOM: 在内存中构造与文档中元素相应的树，可以遍历、搜索、修改
		    DTD: 验证文档是否正确
		    JAXP: 用于XML处理的Java API
		    Castor: 开源项目，用于Java对象与XML映射
		 
		// 从对象中生成XML  
		private final static String FILENAME = "serial.xml";  
		public static void main(String[] args) throws IOException {  
		   String a = "hard work and best callback";  
		   new SerialDemoXML().write(a);  
		   new SerialDemoXML().dump();  
		  
		public void write(Object obj) throws IOException {  
		   XMLEncoder os = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FILENAME)));  
		    os.writeObject(obj);  
		    os.close();  
		}  
		public void dump() throws IOException {  
		    XMLDecoder out = new XMLDecoder(new BufferedInputStream(new FileInputStream(FILENAME)));  
		    System.out.println(out.readObject());  
		    out.close();  
		}  
		serial.xml 格式内容如下:  
		<?xml version="1.0" encoding="UTF-8"?>   
		<java version="1.6.0_02" class="java.beans.XMLDecoder">   
		    <string>hard work and best callback</string>   
		</java>  
		控 制台输出  
		hard work and best callback  
		  
		// XSLT转换XML  
		XSLT 可以用来对输出格式进行各种控制  
		Transformer tx = TransformerFactory.newInstance().newTransformer(new StreamSource("people.xml"));  
		tx.transform(new StreamSource("people.xml"), new StreamResult("people.html"));  
		  
		// 用SAX解析XML - 主要用于查找关键元素，不用全文遍历  
		public SaxLister() throws SAXException, IOException {  
		    XMLReader parser = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");  
		    parser.setContentHandler(new PeopleHandler());  
		    parser.parse("C:\\StudySource\\javacooksrc2\\xml\\people.xml");  
		}  
		class PeopleHandler extends DefaultHandler {  
		    boolean parent = false;  
		    boolean kids = false;  
		    public void startElement(String nsURI, String localName, String rawName, Attributes attr) throws SAXException {  
		        System.out.println("startElement: " +  localName + "," + rawName);  
		        if (rawName.equalsIgnoreCase("name"))  
		            parent = true;  
		        if (rawName.equalsIgnoreCase("children"))  
		        kids = true;  
		    }  
		    public void characters(char[] ch, int start, int length) {  
		        if (parent) {  
		            System.out.println("Parent: " + new String(ch, start, length));  
		            parent = false;  
		        } else if (kids) {  
		            System.out.println("Children: " + new String(ch, start, length));  
		            kids = false;  
		        }  
		    }  
		    public PeopleHandler() throws SAXException {  
		        super();  
		    }  
		}  
		  
		// DOM解析XML - 遍历整个树  
		String uri = "file:" + new File("C:\\StudySource\\javacooksrc2\\xml\\people.xml").getAbsolutePath();  
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
		DocumentBuilder builder = factory.newDocumentBuilder();  
		Document doc = builder.parse(uri);  
		NodeList nodes = doc.getChildNodes();  
		for (int i = 0; i < nodes.getLength(); i++) {  
		    Node n = nodes.item(i);  
		    switch (n.getNodeType()) {  
		    case Node.ELEMENT_NODE:  
		        // todo  
		        break;  
		    case Node.TEXT_NODE:  
		        // todo  
		        break;  
		    }  
		}  
		  
		// 使用DTD或者XSD验证  
		定 义好DTD或XSD文件  
		XmlDocument doc = XmlDocument.createXmlDocument(uri, true);  
		  
		// 用DOM生成XML  
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();  
		DocumentBuilder parser = fact.newDocumentBuilder();  
		Document doc = parser.newDocument();  
		Node root = doc.createElement("Poem");  
		doc.appendChild(root);  
		Node stanza = doc.createElement("Stanza");  
		root.appendChild(stanza);  
		Node line = doc.createElement("Line");  
		stanza.appendChild(line);  
		line.appendChild(doc.createTextNode("Once, upon a midnight dreary"));  
		line = doc.createElement("Line");  
		stanza.appendChild(line);  
		line.appendChild(doc.createTextNode("While I pondered, weak and weary"));  

		      //18. RMI
		 
		a. 定义 客户端与服务器之间的通信接口  
		public interface RemoteDate extends Remote {  
		    public Date getRemoteDate() throws RemoteException;  
		    public final static String LOOKUPNAME = "RemoteDate";  
		}  
		  
		b. 编 写RMI服务器  
		public class RemoteDateImpl extends UnicastRemoteObject implements RemoteDate {  
		    public RemoteDateImpl() throws RemoteException {  
		         super();  
		     }  
		     public Date getRemoteDate() throws RemoteException {  
		         return new Date();  
		     }   
		 }  
		 RemoteDateImpl im = new RemoteDateImpl();  
		 System.out.println("DateServer starting...");  
		 Naming.rebind(RemoteDate.LOOKUPNAME, im);  
		 System.out.println("DateServer ready.");  
		   
		 c. 运 行rmic生成stub  
		 javac RemoteDateImpl.java  
		 rmic RemoteDateImpl  
		   
		 d. 编 写客户端  
		 netConn = (RemoteDate)Naming.lookup(RemoteDate.LOOKUPNAME);  
		 Date today = netConn.getRemoteDate();  
		 System.out.println(today.toString());  
		   
		 e. 确 保RMI注册表运行  
		 rmiregistry  
		   
		 f. 启 动服务器  
		 java RemoteDateImpl  
		       
		 g. 运 行客户端  
		 java DateClient  

		//19. 包和包装机制
		jar cvf /tmp/test.jar .  // 当前目录压缩到test.jar中
		jar xvf /tmp/test.jar  // 把test.jar解压到当前目录
		从指定class运行jar文件
		a. Main-Class: HelloWord  // 注意中间有一个空格
		b. jar cvmf manifest.mf hello.jar HelloWorld.class
		c. java -jar hello.jar

		//20. Java线程

		// 停止线程 - 不要使用stop()方法  
		private boolean done = false;  
		public void run() {  
		    while (!done) {  
		        //todo  
		    }  
		}  
		public void shutDown() {  
		    done = true;  
		 }  
		 可 以调用shutDown()方法来结束线程  
		   
		 // 如果读取IO的时候出现堵塞，那么可以使用下面方法  
		 public void shutDown() throws IOException {  
		     if (io != null)   
		         io.close();  
		 }  
		   
		 // 启动一线程，等待控制台输入，使用join()方法来暂停当前线程，直到其他线程调用  
		 Thread t = new Thread() {  
		     public void run() {  
		         System.out.println("Reading");  
		         try {  
		             System.in.read();  
		         } catch (IOException e) {  
		             System.err.println(e);  
		         }  
		         System.out.println("Thread finished.");  
		     }  
		 };  
		 System.out.println("Starting");  
		 t.start();  
		 System.out.println("Joining");  
		 try {  
		     t.join();  
		 } catch (InterruptedException e) {  
		     System.out.println("Who dares imterrupt my sleep?");  
		 }  
		 System.out.println("Main finished.");  
		   
		 // 加锁保证同步  
		 Lock lock = new ReentrantLock();  
		 try {  
		     lock.lock();  
		     // todo  
		 } finally {  
		     lock.unlock();     
		 }  
		   
		 线 程通信wait(), notify(), notifyAll()  
		 生产者-消费者模式  
		 Executors  

		//21. 内省或“命令类的类”

		// 反射  
		Class c = Class.forName("java.lang.String");  
		Constructor[] cons = c.getConstructors();  
		for (int i = 0; i < cons.length; i++) {  
		    System.out.println(cons[i].toString());  
		}  
		Method[] meths = c.getMethods();  
		for (int i = 0; i < meths.length; i++) {  
		    System.out.println(meths[i].toString());  
		 }  
		   
		 // 动态装载类  
		 Class c = Class.forName("java.lang.String");  
		 Object obj = c.newInstance();  
		   
		 // 通过反射调用类的方法  
		 class X {  
		     public void master(String s) {  
		         System.out.println("Working on \"" + s + "\"");  
		     }  
		 }  
		 Class clx = X.class;  
		 Class[] argTypes = {String.class};  
		 Method worker = clx.getMethod("master", argTypes);  
		 Object[] theData = {"Chocolate chips"};  
		 worker.invoke(new X(), theData);  
		 输 出: Working on "Chocolate chips"  

		//22. Java与其他语言的结合

		// 执行CMD命令，在Eclipse控制台输出  
		Process p = Runtime.getRuntime().exec("C:/StudySource/ver.cmd");  
		p.waitFor(); // 等待命令执行完  
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));  
		String s;  
		while ((s = br.readLine()) != null)  
		    System.out.println(s);  
		      
		// 调用Jython - 计算22.0/7  
		 BSFManager manager = new BSFManager();  
		 String[] fntypes = {".py"};  
		 manager.registerScriptingEngine("jython", "org.apache.bsf.engines.jython.JythonEngine", fntypes);  
		 Object r = manager.eval("jython", "testString", 0, 0, "22.0/7");  
		 System.out.println("Result type is " + r.getClass().getName());  
		 System.out.println("Result value is " + r);  	
	*/ 
    
	}

}
