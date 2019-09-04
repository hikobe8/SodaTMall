import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * Author : Ray
 * Created At : 2019-09-03 6:24 PM
 * Email : ryu18356@gmail.com
 * Description : servlet上传图片demo
 */
public class UploadPhotoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
            diskFileItemFactory.setSizeThreshold(1024 * 1024 * 2); //限制大小为2M
            List list = upload.parseRequest(req);
            Iterator iterator = list.iterator();
            String fileName = "";
            String path = req.getServletContext().getRealPath("upload");
            File uploadDir = new File(path);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            while (iterator.hasNext()) {
                FileItem item = (FileItem) iterator.next();
                if (!item.isFormField()) {
                    if (fileName.length() < 1) {
                        fileName = String.valueOf(System.currentTimeMillis())+".jpg";
                    }
                    File uploadFile = new File(uploadDir, fileName);
                    FileOutputStream fos = new FileOutputStream(uploadFile);
                    InputStream inputStream = item.getInputStream();
                    byte[] buffer = new byte[1024 * 1024];
                    int len = -1;
                    while ((len = inputStream.read(buffer)) != -1) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                    inputStream.close();

                } else {
                    System.out.println("item.getName() = " + item.getName());
                    System.out.println("item.getFieldName() = " + item.getFieldName());
                    System.out.println("item.getString() = " + item.getString());
                    fileName = item.getString();
                }
            }
            resp.setContentType("text/html; charset=UTF-8");
            String respString = "<img src='upload/%s'/>";
            resp.getWriter().format(respString, fileName);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
