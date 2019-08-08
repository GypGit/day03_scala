package day03_scala

/*
 @author gyp
 @create 2019/8/5
*/
object demo8_trait {

  trait HandlerTrait {
    def handler(msg: String): Unit = {
      println("处理数据..." + msg)
    }
  }

  trait DataValidHandlerTrait extends HandlerTrait {
    override def handler(msg: String): Unit = {
      println("验证数据...")

      super.handler(msg)
    }
  }

  trait SignatureValidHandlerTrait extends HandlerTrait {
    override def handler(msg: String): Unit = {
      println("检查签名...")

      super.handler(msg)
    }
  }

  class PaymentService extends DataValidHandlerTrait with SignatureValidHandlerTrait {
    override def handler(msg: String): Unit = {
      println("准备支付")

      super.handler(msg)
    }
  }

  def main(args: Array[String]): Unit = {
    val service = new PaymentService
    service.handler("666")
  }
}
