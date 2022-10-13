mysql8的配置
1、驱动包的变化,.com.mysql.cj.jdbc.Driver
2、需要增加时区 ?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai

mysql5的配置
1、驱动包的变化,.com.mysql.jdbc.Driver
2、需要增加时区 ?useSSL=false&useUnicode=true&characterEncoding=utf-8

mysql的 url参数详解
| 参数名                 | **含义**                                                     | **通常取值**  |
| ---------------------- | ------------------------------------------------------------ | ------------- |
| `user`                 | 数据库用户名（用于连接数据库）                               | -----         |
| `passWord`             | 用户密码（用于连接数据库）                                   | -----         |
| `useSSL`               | useSSL 5.7.17版本服务器默认是true 如果不使用SSL连接就要在urL中设置useSSL=false | false         |
| `useUnicode`           | 是否使用Unicode字符集，如果参数characterEncoding设置为gb2312或gbk，本参数值必须设置为true | true          |
| `characterEncoding`    | 当useUnicode设置为true时，指定字符编码。比如可设置为gb2312或gbk | utf8          |
| `serverTimezone`       | 用于设置时区时间                                             | Asia/Shanghai |
| autoReconnect          | 当数据库连接异常中断时，是否自动重新连接？                   | -----         |
| autoReconnectForPools  | 是否使用针对数据库连接池的重连策略                           | -----         |
| maxReconnects          | autoReconnect设置为true时，重试连接的次数                    | -----         |
| failOverReadOnly :     | 自动重连成功后，连接是否设置为只读？                         | -----         |
| zeroDateTimeBehavior : | `exception`：默认值，即抛出SQL state [S1009]. Cannot convert value…的异常 `convertToNull`：将日期转换成NULL值；`round`：替换成最近的日期即0001-01-01 | convertToNull |

