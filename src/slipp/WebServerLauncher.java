package slipp;

import java.io.File;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
 
public class WebServerLauncher {
    public static void main(String[] args) throws Exception {
        String webappDirLocation = "WebContent/";				// 여기를 비부악으로 삼는다는 뜻 같다.
        Tomcat tomcat = new Tomcat();         					// 톰캣이라는 컨테이너를 생성하는 것 같군. 오호라, 이게 바로 임베디드 톰캣인가? 
        tomcat.setPort(8080);									// 톰캣에 내가 어떤 포트로 소통할 것인지(개방할 것인지) 세팅하는 거로군.
        
        Connector connector = tomcat.getConnector();			// 포트도 설정했겠다, 이젠 진짜 웹과 연결할 커넥터? 소켓을 마련하는 군. 커넥터는 톰캣 자체적으로 가지고 있는 커넥터로 하는 군.
        connector.setURIEncoding("UTF-8");						// 그 커넥터의 인코딩 방식도 UTF-8로 셋팅하고.
        
        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());		// 자, 이렇게 설정한 톰캣 컨테이너에 웹어플리케이션(jsp파일들?)이 있는 주소를 설정하는구먼.
        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());
        
        tomcat.start();					// 자, 시작하자!!
        tomcat.getServer().await(); 	// 뭔진 모르겠지만 뭔가 돌아가기 시작하는 듯.
    }
}
