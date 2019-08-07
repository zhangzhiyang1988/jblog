package jblog.guohai.org.service;

import jblog.guohai.org.Repository.BlogRepository;
import jblog.guohai.org.model.BlogContent;
import jblog.guohai.org.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {


    @Autowired
    private BlogRepository blogRepository;
    /**
     * 前台用的页大小
     */
    private final Integer pageSize = 10;

    /**
     * 获得指定ID的
     *
     * @param code
     * @return
     */
    @Override
    public BlogContent getByID(Integer code) {
//        return blogDao.getContentById(code);
        return blogRepository.findBlogContentByPostCode(code);
    }

    /**
     * 活的指定日期的
     *
     * @param sDate
     * @param smallTitle
     * @return
     */
    @Override
    public BlogContent getByYMDTitle(String sDate, String smallTitle) {
//        return blogDao.getContentByYMDTitle(sDate, smallTitle);
          return blogRepository.findBlogContentByPostSmallTitleAndPostDate(smallTitle,sDate);
    }

    /**
     * 活的下一条BLOG
     *
     * @param code
     * @return
     */
    @Override
    public BlogContent getNextBlog(Integer code) {
//        return blogDao.getNextBlog(code);
          return blogRepository.findBlogContentByPostCode(code);
    }

    /**
     * 获得上一条BLOG
     *
     * @param code
     * @return
     */
    @Override
    public BlogContent getLastBlog(Integer code) {
//        return blogDao.getLastBlog(code);
          return blogRepository.findBlogContentByPostCode(code);
    }


    /**
     * 获得指定页号数据
     *
     * @param pageNumber
     * @return
     */
    @Override
    public List<BlogContent> getByPage(Integer pageNumber) {
        //return blogDao.getByPage((pageNumber - 1) * pageSize, pageSize);
        Page page = blogRepository.findAll(new PageRequest(pageNumber,pageSize));
        return page.getContent();
    }

    /**
     * 返回 总数量
     *
     * @return
     */
    @Override
    public Integer getMaxPageNum() {
//        int postCount = blogDao.getPostCount();
          int postCount = blogRepository.findAllByPostStatus("publish").size();
        return postCount % pageSize == 0 ? postCount / pageSize : postCount / pageSize + 1;
    }

    /**
     * 增加一篇BLOG
     *
     * @param blog BLOG实体
     * @return 返回结果情况
     */
    @Override
    public Result<String> addPostBlog(BlogContent blog) {
        Result<String> result = new Result<String>();
        //blogDao.addPostBlog(blog);
        blogRepository.save(blog);
        if (blog.getPostCode() > 0) {
            result.setState(true);
            result.setData("Success:" + blog.getPostCode());
        } else {
            result.setState(false);
            result.setData("Error");
        }
        return result;
    }
}
