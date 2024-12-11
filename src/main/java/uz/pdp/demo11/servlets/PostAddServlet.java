package uz.pdp.demo11.servlets;

import jakarta.persistence.EntityManager;
import uz.pdp.demo11.entity.Attachment;
import uz.pdp.demo11.entity.Post;
import uz.pdp.demo11.repo.AttachmentRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

import static uz.pdp.demo11.config.MyListener.emf;

@MultipartConfig
@WebServlet("/post/add")
public class PostAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (
                EntityManager entityManager = emf.createEntityManager();
                ){
            Part video = req.getPart("video");
            Part cover = req.getPart("cover");
            Part audio = req.getPart("audio");
            String title = req.getParameter("title");
            Attachment coverAttachment=AttachmentRepo.saveFile(cover.getSubmittedFileName(),cover.getInputStream().readAllBytes());
            Attachment audioAttachment=AttachmentRepo.saveFile(audio.getSubmittedFileName(),audio.getInputStream().readAllBytes());
            Attachment videoAttachment=AttachmentRepo.saveFile(video.getSubmittedFileName(),video.getInputStream().readAllBytes());
            Post post = new Post(title,coverAttachment,audioAttachment,videoAttachment);
            entityManager.getTransaction().begin();
            entityManager.persist(post);
            entityManager.getTransaction().commit();
            resp.sendRedirect("/post.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
