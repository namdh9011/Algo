package y2021.m04.d26;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class 자막변환 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Iron Man1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while((s=br.readLine())!=null) {
			try {
				int temp = Integer.parseInt(s);
				i++;
				if(temp!=i) {
					System.out.println(s);
				}
			} catch (Exception e) {
				if(!s.equals("")&&!s.contains("-->")) {
					sb.append(s).append("\n");
				}
			}
		}
		String message = sb.toString();
		File file = new File("Iron Man1.txt");
        FileOutputStream fos = null;
        
        try {
            fos = new FileOutputStream(file);
            
            // FileOutputStream 클래스가 파일에 바이트를 내보내는 역할을 하는 클래스이므로
            // 내보낼 내용을 바이트로 변환을 하는 작업이 필요합니다.
            byte[] content = message.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
            
            System.out.println("DONE");
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fos != null) fos.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
	}
}
