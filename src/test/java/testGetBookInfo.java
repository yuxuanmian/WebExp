import com.beans.BookBean;
import com.controller.BookInfo;

import java.util.List;


public class testGetBookInfo {
    public static void main(String[] args) {
        BookInfo bif=new BookInfo();
        List<BookBean>list= bif.getAllBookBean();
        for(BookBean bb:list){
            System.out.println(bb);
        }
    }
}
