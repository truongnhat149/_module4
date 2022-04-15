package lpnt.cg.service.blog;

import lpnt.cg.model.Blog;
import lpnt.cg.model.Category;
import lpnt.cg.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {

    Iterable<Blog> findAllByCategory(Category category);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    List<Blog> findAllByIdOrTitle(Long id, String title);

    List<Blog> findAllByIdOrTitleNavtiveQuery(@Param("keySearch") String keySearch);

}
