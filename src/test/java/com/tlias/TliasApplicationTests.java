package com.tlias;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

 @SpringBootTest
class TliasApplicationTests {

  @Test
  void contextLoads() {}

  @Test
  public void testGenJwt() {
    Map<String, Object> claims = new HashMap<>();
    claims.put("id", 1);
    claims.put("name", "tom");

    //eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY4NDQwNTcxNX0.iytgwzlu7W8Lju4FpTMjqJwy-gnw8sNljOPVgDK1g_A
    String jwt =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, "littleNine") // 设置签名算法
            .setClaims(claims) // 设置载荷
            .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置过期时间
            .compact();

    System.out.println(jwt);
  }


  @Test
  public void testParseJwt() {
    Claims claims =
        Jwts.parser()
            .setSigningKey("littleNine")
            .parseClaimsJws(
                "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY4NDQwNTcxNX0.iytgwzlu7W8Lju4FpTMjqJwy-gnw8sNljOPVgDK1g_A")
            .getBody();

    System.out.println(claims);
  }
}
