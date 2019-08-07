package jblog.guohai.org.Repository;

import jblog.guohai.org.model.BlogContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author:Zhangzy
 * Date:2019/8/7
 * Time:9:35
 */
@Repository
public interface BlogRepository extends JpaRepository<BlogContent,Long> {

    BlogContent findBlogContentByPostCode(int postCode);

    BlogContent findBlogContentByPostSmallTitleAndPostDate(String smallTitle,String postDate);

    Page<BlogContent> findAll(Pageable pageRequest);

    List<BlogContent> findAllByPostStatus(String postStatus);

}
