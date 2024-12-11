package uz.pdp.demo11.repo;

import jakarta.persistence.EntityManager;
import uz.pdp.demo11.entity.Attachment;
import uz.pdp.demo11.entity.AttachmentContent;

import static uz.pdp.demo11.config.MyListener.emf;

public class AttachmentRepo {
    public static Attachment saveFile(String submittedFileName, byte[] bytes) {
        try (
                EntityManager entityManager = emf.createEntityManager();
                ){
            Attachment attachment = new Attachment(submittedFileName);
            AttachmentContent attachmentContent = new AttachmentContent(attachment,bytes);
            entityManager.getTransaction().begin();
            entityManager.persist(attachment);
            entityManager.persist(attachmentContent);
            entityManager.getTransaction().commit();
            return attachment;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
