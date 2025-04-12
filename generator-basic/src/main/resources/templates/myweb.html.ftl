<!DOCTYPE html>

  <head>
    <title>Halo 官网</title>
  </head>
  <body>
    <h1>欢迎来到 Halo 官网</h1>
    <ul>
      <#-- 导航条 -->
      <#list menuItems as item>
          <li><a href="${item.url}">${item.label}</a></li>
      </#list>
    </ul>
    <#-- 底部注释 -->
    <footer>
      ${currentYear} Halo 官网 . All rights reserved.
    </footer>
  </body>

</html>

