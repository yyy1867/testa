package ml.guxing.demo.spring;

/**
 * 建设者模式
 */
public class EntityBuilderMode {

    public static void main(String[] args) {
        TestEntity entity = new TestEntity.TestEntityBuilder()
                .setCode("测试code")
                .setName("测试name")
                .builder();
        System.out.println(entity.toString());
    }

    private static class TestEntity {
        private String name;
        private String code;

        public TestEntity(String name, String code) {
            this.name = name;
            this.code = code;
        }

        @Override
        public String toString() {
            return "TestEntity{" +
                    "name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    '}';
        }

        private static class TestEntityBuilder {
            private String name;
            private String code;

            public TestEntityBuilder setName(String name) {
                this.name = name;
                return this;
            }

            public TestEntityBuilder setCode(String code) {
                this.code = code;
                return this;
            }

            public TestEntity builder() {
                return new TestEntity(name, code);
            }
        }

    }

}
