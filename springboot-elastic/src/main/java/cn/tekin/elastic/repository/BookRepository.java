package cn.tekin.elastic.repository;

import cn.tekin.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-22 16:24
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {
    //参考
    // https://docs.spring.io/spring-data/elasticsearch/docs/3.2.x/reference/html/#elasticsearch.clients
    // https://docs.spring.io/spring-data/elasticsearch/docs/3.0.6.RELEASE/reference/html/
    public List<Book> findByBookNameLike(String bookName);
}
