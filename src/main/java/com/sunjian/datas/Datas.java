package com.sunjian.datas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sunjian.utils.Path;

import au.com.bytecode.opencsv.CSVReader;

/**
 * 使用csv文件存储测试数据
 * 
 * @author sunjian
 *
 */
public class Datas {
	private String filePath;
	private String nextLine[];
	List<String[]> approvalList = new ArrayList<String[]>();
	CSVReader reader;
	private String value;
	
	private BufferedReader br;
	
	public Datas (String filePath){
		this.filePath = filePath;
	}
	
	/**
	 * @author sunjian
	 * @param  columnName
	 * @param  lineName
	 */
	
	//获取csv文件中存储的内容
	public String getTestData(String columnName,String lineName){
		try {
			reader = new CSVReader(new FileReader(filePath));
			try{
				while ((nextLine = reader.readNext()) != null) {
					approvalList.add(nextLine);
				}
			}catch(IOException e){
				e.printStackTrace();
			}
			
			//获取某一列
			int count = 0;
			int index = 0;
			
			for(String j:approvalList.get(0)){
				count++;
				if(j.equals(columnName)){
					index = count-1;
				}
			}
			
			//获取某一行
			for(String[]i:approvalList){
				if(i[0].equals(lineName))
					value = i[index].toString();
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return value;
	}
			
	//获取文件的列数
	public int getColumnNum(){
		int columnNum = 0;
		String allColumnName = "";
		try {
			br = new BufferedReader(new FileReader(filePath));
			if ((allColumnName = br.readLine())!=null && !allColumnName.equals("")) {
				String [] allColumnNum = allColumnName.split(",");
				for(int i=0;i<allColumnNum.length;i++){
					columnNum++;
				}
			}else {
				return columnNum;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return columnNum;
	}
	
	//获取文件的行数
	public int getRowNum(){
		int rowNum = 0;
		String allColumnName = "";
		try {
			br = new BufferedReader(new FileReader(filePath));
			
			while((allColumnName = br.readLine())!=null && !"".equals(allColumnName)){
					rowNum++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowNum;
	}
	
	public static void main(String[] args){
		//找到csv文件的位置
		Datas datas = new Datas(Path.deskTop()+"test1.csv");

		System.out.println("列数==>"+datas.getColumnNum()+"行数==>"+datas.getRowNum());
		for(int i=1; i<datas.getColumnNum(); i++){
			for(int j=1; j<datas.getRowNum(); j++){				
				System.out.println(datas.getTestData("username", "v"+j)+","
						+datas.getTestData("password", "v"+j)
				);
			}
		}
	}

}
