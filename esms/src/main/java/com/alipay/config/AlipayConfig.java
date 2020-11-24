package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author gdx
 * @description
 * @date 2020/1/13
 */
public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

        // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
        public static String app_id = "2016102100730000";

        // 商户私钥，您的PKCS8格式RSA2私钥
        public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDJgjbhPykyut7XJQ/euvbI3aqVHREHrUZF/Yq0SmDwktpxeByWJ6YKqUH7ivHYCdbY0xluu73hKcQ6FxQmnzLMNDb1poo+Pg4aGE8iQk4FdMBaIjzfhwS9z49VkNW231gxzTP9TIxK6Z5c7PxkSQmWroz59q8aU9mwO7Ivpj0dIJNyqO/lhuj2gkkzU8Bg8KU9dO3OJe13QblOlwl4l43AFkX1MYMlGJx027rUMaTwg78muOe/iJ6fmoSU9m4w1pSLGjYDGkkJMw1RCEVJk1vNmDmV7mVguRkckgg/O6bAUteNn6u3i/FYYhQ6TxlQGHm2/mg4ua/kdUP9PRzARmmhAgMBAAECggEAQhqIXE32+uBYl+Vdlmho6q3k9rOpUYZjJjStWsWHlYPnSw/m+M8a5iZuMdF70q4vn8NodW37NTEZYSEPCDhzVo/Oc7llYlPDFoZg91Ee/SU2sJrIs188i/PaBmzT3wDXksbJRk/lOfH3dG59wXxAPAEY2Cs3eACHygtbQcxcAgCHHEVMOuRPdbU9mjQUow8zazkpYp3HP5W49p8QAw15rWmLWBHF9O7VykwG3CONcw5fSkGwly5DKVJ9crnAcIY3NnkScDSlX0kRg0mhb3kIuxRxae5VxYOEomBAxI9Isj4O/4QYt1UexR8s2z060uS6jXhXY3PX/ReQCcavEADoHQKBgQD4vA50+kTNWebATNTdeTijUjnc1FqIp8h3JZl/AdWJBHYqvOI54FkeK56waLx4Qg2uo0Edfb6qKE4ikKYbh/ir2B/qi71EcAQHWRv+IjT4PzMrjuPpsKfLh7zbPqkKhRaRNHxgp7kqDMHJztKxxc9bd4kkH1F40c+k2rtH3RDOuwKBgQDPZQUkUDEirDXB5Xy+sVO9inB898GhmBSGrxGiHGLF+0fKg+vPdT/3ifVCnw9eu8ajfhwamUBfCxlKV5SrjtdQuh5sXQv03o089AP9N/xsV7aahR7xnyrXyxi/0waZNmdmqIxNjqoQwAXcuQbaQYAN32a6hafbClEo8tIgQQd5UwKBgQC1c3LUcTI53+iOxj3PJzxjIHvnld5JrKR4DqzQU0U0RFXzzYD3GavJb6a/KFi9HeqfSKca3X124hpF6uHSWbnVmr+FudUjlNfLiHz8QnYD1w78Kqwm8WEm/+mMw0RL0VTqLrDBTfmtLEs+biuT1irzndskx9gGXICu0YYn4aP+OwKBgQCbC/fbHQSO2lXaHlmzKljjc7MDCio9R7fYtNsm6bfCMUiLkzJgx1RKGF4+LzHLbfBj2+zgyb+BDogatv0TgNdhp7ME6k79AsBuWDL/RLK2wKBoRqtKkebyqwhWqEnfkvecnNc/SC/GE/iN+dmwo5U7Sc/AFBnYPI9OYLJMoLEYtwKBgQDWStslfocNzHew/iPowE0yOiYjy6EKiIgGkpOVQ0doxOqTRpG8808Pfz1ckVmnsrJ5waKW/SPOcltX5rkIhg5ZOKPVgjgRLdL8IXgacTuIHGNcJlMB4rmwT+8Ofi6kxTfmppFUKXsfSfneh2VC+L42yyG2iJW1AUfx8Ln6DGg8FQ==";

        // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
        public static String alipay_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";
        // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
        public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

        // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
        public static String return_url = "http://localhost:9527/esms/payReturn";

        // 签名方式
        public static String sign_type = "RSA";

        // 字符编码格式
        public static String charset = "utf-8";

        // 支付宝网关
        public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

        // 支付宝网关
        public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

        /**
         * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
         * @param sWord 要写入日志里的文本内容
         */
        public static void logResult(String sWord) {
            FileWriter writer = null;
            try {
                writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
                writer.write(sWord);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

