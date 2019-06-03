package kr.or.ddit.util;

public class PartUtil {

	/**
	 * Method : getFileName 작성자 : PC13 변경이력 :
	 * 
	 * @param contentDisposition
	 * @return Method 설명 : contentDisposition에서 파일명을 반환한다.
	 */
	public static String getFileName(String contentDisposition) {
		// form-data; name="profile"; filename="sally.png"

		String[] file = contentDisposition.split("; ");
		String fileValue = "";

		for (String str : file) {
			if (str.startsWith("filename=")) {
				String[] fileStr = str.split("\"");
				fileValue = fileStr[1];
				break;
			}
		}
		return fileValue;
	}

	/**
	 * Method : getExt 작성자 : PC13 변경이력 :
	 * 
	 * @param fileName
	 * @return Method 설명 : 파일명으로부터 파일 확장자를 반환
	 */
	public static String getExt(String fileName) {
		//방법1
		String str ="";
		if (fileName.contains(".")) {
			str = fileName.substring(fileName.lastIndexOf("."));
		}
		return str;
		
		//방법2
//		String[] splited = fileName.split("\\."); //[.] 도 가능
//		if(splited.length ==1){
//			return "";
//		}else{
//			return splited[splited.length-1];
//		}
	}
}
