package ml.guxing.test.scala.core.aop

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.{Aspect, Before}
import org.springframework.stereotype.Component

@Aspect
@Component
class DaoAspect {

  //  @Before("execution(public ml.guxing.test.scala.core.dao.*.*(...))")
  @Before("execution(public * ml.guxing.test.scala.core.dao.*.*(..))")
  def before(joinpoint: JoinPoint): Unit = {
    val signature = joinpoint.getSignature
    val args = joinpoint.getArgs
    val methodName = signature.getName
    ""
  }

}
