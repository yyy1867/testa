package ml.guxing.test.scala.core.aop

import ml.guxing.test.scala.core.domain.model.{EntityModel, MetaModel}
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.{Aspect, Before}
import org.springframework.stereotype.Component

//@Aspect
//@Component
class DaoAspect {

  //  @Before("execution(public ml.guxing.test.scala.core.dao.*.*(...))")
  @Before("execution(public * ml.guxing.test.scala.core.dao.*.save(..))")
  def before(joinpoint: JoinPoint): Unit = {
    val args = joinpoint.getArgs
    if (args.length == 1 && args(0).isInstanceOf[EntityModel]) {
      val model: EntityModel = args(0).asInstanceOf[EntityModel]

    }
    ""
  }

}
