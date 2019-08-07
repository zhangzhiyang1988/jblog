package jblog.guohai.org.service;

import jblog.guohai.org.Repository.BlogRepository;
import jblog.guohai.org.model.BlogContent;
import jblog.guohai.org.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    BlogRepository blogRepository;

    /**
     * 后台用的页大小
     */
    private final Integer adminPageSize = 20;

    /**
     * 获得管理后台的BLOG列表
     *
     * @param pageNumber 想获取的页号
     * @return
     */
    @Override
    public List<BlogContent> getBackstageList(Integer pageNumber) {

        //return blogDao.getBackstageList((pageNumber-1)*adminPageSize, adminPageSize);
        Page<BlogContent> page =  blogRepository.findAll(new PageRequest(pageNumber,adminPageSize));
        return page.getContent();
    }

    /**
     * 删除指定编号的BLOG
     *
     * @param postCode blog编号
     * @return 结果
     */
    @Override
    public Result<String> delPostBlog(Integer postCode) {
        if( blogRepository.findBlogContentByPostCode(postCode) == null ) {
            return new Result<>(false,"没有此编号文章");
        }
        BlogContent blog = blogRepository.findBlogContentByPostCode(postCode);
        blogRepository.delete(blog);
        return new Result<>(true,"删除成功");

    }

    /**
     * 后台用的获取最大页数
     *
     * @return
     */
    @Override
    public Integer getBackstageMaxPageNum() {

        int postCount = blogRepository.findAll().size();
        return postCount % adminPageSize == 0 ? postCount / adminPageSize : postCount / adminPageSize + 1;
    }
}
