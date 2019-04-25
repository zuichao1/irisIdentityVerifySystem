package com.sunjian.datas;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用csv文件存储测试数据
 * 如果文件中有中文的话，用这个
 * 
 * @author sunjian
 *
 */
public class Datas2 {
	private String filePath;
	private String nextLine[];
	List<String[]> approvalList = new ArrayList<String[]>();
	DataInputStream dis;
	BufferedReader bufr;
	private String value;
	
	private BufferedReader br;
	
	public Datas2 (String filePath){
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
			dis = new DataInputStream(new FileInputStream(filePath));
			bufr = new BufferedReader(new InputStreamReader(dis, "GBK"));
			String line = "";
			while((line = bufr.readLine()) != null){
				nextLine = line.split(",");
				approvalList.add(nextLine);
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
			
		}catch(Exception e){
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
			if ((allColumnName = br.readLine())!=null && !"".equals(allColumnName)) {
				String [] allColumnNum = allColumnName.split(",");
				for(int i=0;i<allColumnNum.length;i++)
					columnNum++;
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
		Datas2 datas = new Datas2(System.getProperty("user.dir")+"/src/test/tools/xxx.csv");
		
		//ryfl	xm	zjlx zjh xb	gj	mz	csrq hjdz zjqfjg zjyxq	xjzdz sjhm qtlxdh wfcj bz"
		System.out.println("列数==>"+datas.getColumnNum()+"行数==>"+datas.getRowNum());
		for(int i=1; i<datas.getColumnNum(); i++){
			for(int j=1; j<datas.getRowNum(); j++){				
				System.out.println(datas.getTestData("ryfl", "v"+j)+","
						+datas.getTestData("xm", "v"+j)+","
						+datas.getTestData("zjlx", "v"+j)+","
						+datas.getTestData("zjh", "v"+j)+","
						+datas.getTestData("xb", "v"+j)+","
						+datas.getTestData("gj", "v"+j)+","
						+datas.getTestData("mz", "v"+j)+","
						+datas.getTestData("csrq", "v"+j)+","
						+datas.getTestData("hjdz", "v"+j)+","
						+datas.getTestData("zjqfjg", "v"+j)+","
						+datas.getTestData("zjyxq", "v"+j)+","
						+datas.getTestData("xjzdz", "v"+j)+","
						+datas.getTestData("sjhm", "v"+j)+","
						+datas.getTestData("qtlxdh", "v"+j)+","
						+datas.getTestData("wfcj", "v"+j)+","
						+datas.getTestData("bz", "v"+j));
			}
		}
		
	}

}
