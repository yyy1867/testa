package ml.guxing.test.core.config

import cn.org.rapid_framework.freemarker.directive.BlockDirective
import cn.org.rapid_framework.freemarker.directive.ExtendsDirective
import cn.org.rapid_framework.freemarker.directive.OverrideDirective
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.context.annotation.Configuration

import javax.annotation.PostConstruct

@Configuration
@ConditionalOnClass(value = [BlockDirective.class, OverrideDirective.class, ExtendsDirective.class])
class FreeMorkerConfig {

    @Autowired
    freemarker.template.Configuration configuration

    /**
     *  使freemorker 支持 block,override,extends 标签,方便使用模板继承
     */
    @PostConstruct
    public void setSharedVariable() {
        configuration.setSharedVariable("block", new BlockDirective());
        configuration.setSharedVariable("override", new OverrideDirective());
        configuration.setSharedVariable("extends", new ExtendsDirective());
    }
}
