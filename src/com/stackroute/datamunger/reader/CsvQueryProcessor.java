package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {
	String filename;	
	// parameterized constructor to initialize filename
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {
		this.filename=fileName;
		System.out.println(fileName);
	}

	/*
	 * implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file.
	 * Note: Return type of the method will be Header
	 */
	@Override
	public Header getHeader() throws IOException {

		// read the first line

		// populate the header object with the String array containing the header names
		
	System.out.println(this.filename);
			BufferedReader br = new BufferedReader(new FileReader(this.filename));
			System.out.println("tata");
        String header = br.readLine();
            String[] columns = header.split(",");
            for(int i=0;i<columns.length;i++) {
            	columns[i]=columns[i].trim();
            	System.out.println(columns[i]);}
            Header head=new Header(columns);
            return head;
		//return null;
		
	}

	/**
	 * getDataRow() method will be used in the upcoming assignments
	 */
	@Override
	public void getDataRow() {

	}

	/*
	 * implementation of getColumnType() method. To find out the data types, we will
	 * read the first line from the file and extract the field values from it. If a
	 * specific field value can be converted to Integer, the data type of that field
	 * will contain "java.lang.Integer", otherwise if it can be converted to Double,
	 * then the data type of that field will contain "java.lang.Double", otherwise,
	 * the field is to be treated as String. 
	 * Note: Return Type of the method will be DataTypeDefinitions
	 */
	@Override
	public DataTypeDefinitions getColumnType() throws IOException {
		try {// String[] columns = header2.split(",");
			//
			// for (int i = 0; i < columns.length; i++) {
			// try {
			// Integer.parseInt(columns[i]);
			// System.out.print(headerss[i]);
			// System.out.println(((Object) columns[i]).getClass().getName());
			// } catch (Exception e) {
			// System.out.print(headerss[i]);
			// System.out.println(((Object) columns[i]).getClass().getName());
			// }
			// }
			BufferedReader br = new BufferedReader(new FileReader("data/ipl.csv"));
			String header = br.readLine();
			String header2 = br.readLine();
			
				String[] headerss = header.split(",");
				System.out.println(headerss.length);
				if (header2 != null) {
					String[] col=new String[headerss.length];
				String[] columns = header2.split(",",-1);
				System.out.println(columns.length);
				 for (int i = 0; i < columns.length; i++) {
					 if(!columns[i].isEmpty()) {
					 try {
						 int num=Integer.parseInt(columns[i]);
						 System.out.print(headerss[i]);
						 col[i]=((Object) num).getClass().getName();
						 System.out.println(col[i]);
						 } catch (Exception e) {
						System.out.print(headerss[i]);
						col[i]=((Object) columns[i]).getClass().getName();
						System.out.println(col[i]);
						 }
					 }
					 else {
						 String ag="";
						 col[i]=ag.getClass().getName();
							System.out.println(col[i]);
					 }
				 }
				DataTypeDefinitions a = new DataTypeDefinitions(col);
				return a;
			} else
				return null;
			// return null;
		} catch (Exception e) {
			System.out.println("file not found");
			return null;
		}
	}
}
