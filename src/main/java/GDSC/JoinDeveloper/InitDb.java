package GDSC.JoinDeveloper;

import GDSC.JoinDeveloper.domain.comment.entity.Comment;
import GDSC.JoinDeveloper.domain.participation.entity.Participation;
import GDSC.JoinDeveloper.domain.post.entity.PersonnelStatus;
import GDSC.JoinDeveloper.domain.post.entity.Post;
import GDSC.JoinDeveloper.domain.user.entity.Part;
import GDSC.JoinDeveloper.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final EntityManager em;

        public void dbInit1(){

            User user1 = new User("hunil1@naver.com","1123","1이훈일","110-1234-5678", Part.BACKEND);
            User user2 = new User("hunil2@naver.com","2123","2이훈일","210-1234-5678", Part.APP);
            User user3 = new User("hunil3@naver.com","3123","3이훈일","310-1234-5678", Part.FRONTEND);

            em.persist(user1);
            em.persist(user2);
            em.persist(user3);

            Post post1 = new Post(user1,"1","1", LocalDateTime.now(),4,1, PersonnelStatus.POSSIBLE);
            Post post2 = new Post(user2,"2","2", LocalDateTime.now(),4,1, PersonnelStatus.POSSIBLE);
            Post post3 = new Post(user3,"3","3", LocalDateTime.now(),4,1, PersonnelStatus.POSSIBLE);

            em.persist(post1);
            em.persist(post2);
            em.persist(post3);

            Participation participation1 = new Participation(user1,post2);
            Participation participation2 = new Participation(user2,post3);
            Participation participation3 = new Participation(user3,post1);

            em.persist(participation1);
            em.persist(participation2);
            em.persist(participation3);

            Comment comment1 = new Comment(post1,user3,"1",LocalDateTime.now());
            Comment comment2 = new Comment(post2,user1,"2",LocalDateTime.now());
            Comment comment3 = new Comment(post3,user2,"3",LocalDateTime.now());

            em.persist(comment1);
            em.persist(comment2);
            em.persist(comment3);
        }
    }
}
