package ml.guxing.demo.spring;


import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * 解释器模式测试
 */
public class ExpressionParserMode {

    public static void main(String[] args) {
        TestEntity testEntity = new TestEntity("test", "测试");
        System.out.println(testEntity.toString());
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext evaluationContext = new StandardEvaluationContext(testEntity);
        evaluationContext.setVariable("name", "测试名称");
        parser.parseExpression("name = #name").getValue(evaluationContext);
        System.out.println(testEntity.toString());
    }

    private static class TestEntity {
        private String code;
        private String name;

        private TestEntity() {

        }

        private TestEntity(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "TestEntity{" +
                    "code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
