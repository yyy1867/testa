package ml.guxing.test.core

import ml.guxing.test.core.repository.CoolMenuRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class TestDataSource {

    @Autowired
    CoolMenuRepository coolMenuRepository

    @Test
    def void test1() {
        def all = coolMenuRepository.findAll()
        println(all)
        println(dataSource)
    }

}
