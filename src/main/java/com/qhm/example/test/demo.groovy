def a = 123I
assert a instanceof Integer
def b= 123L
assert b instanceof Long


println 'hello'

def name = '张三'
println "hello $name"

def strippedFirstNewline = '''line one
        line two
            line three
'''
println strippedFirstNewline
// 可以写成下面这种形式，可读性更好
def strippedFirstNewline2 = '''\
line one
    line two
line three
'''
println strippedFirstNewline2

char c1 = 'A' // 声明类型
assert c1 instanceof Character

def c2 = 'B' as char // 用as关键字
assert c2 instanceof Character

def c3 = (char) 'C' // 强制类型转换
assert c3 instanceof Character

//声明返回值（不加def）
String method1() {
    return 'hello'
}
assert method1() == 'hello'
//声明返回值（加def）
def String method2() {
    return 'hello'
}
assert method2() == 'hello'

//不声明返回值（使用def）
def method3() {
    'hello'
}
assert method3() == 'hello'

//声明方法,参数加类型
def add(int a, int b) {
    return a + b
}
//与上面的等价，类型默认为Object
def add(a, b) {
    a + b
}

//定义List
//Groovy 定义 List 的方式非常简洁，使用中括号([])，以逗号(,)分隔元素即可。Groovy中的 List 其实就是java.util.List，实现类默认使用的是java.util.ArrayList。
def numbers = [1, 2, 3]

assert numbers instanceof List
assert numbers.class == java.util.ArrayList
assert numbers.size() == 3



//定义Array(数组)
//Groovy 定义数组的语法和 List 非常类似，区别在于数组的定义必须指定类型为数组类型，可以直接定义类型或者使用def定义然后通过as关键字来指定其类型。
String[] arrStr = ['Ananas', 'Banana', 'Kiwi'] //直接声明类型为数组类型  String[]

assert arrStr instanceof String[]
assert !(arrStr instanceof List)

def numArr = [1, 2, 3] as int[]     //痛过as关键字指定类型为数组类型 int[]

assert numArr instanceof int[]
assert numArr.size() == 3


// key虽然没有加引号，不过Groovy会默认将其转换为字符串
def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']

assert colors['red'] == '#FF0000' // 使用中括号访问
assert colors.green == '#00FF00' // 使用点表达式访问

colors['pink'] = '#FF00FF' // 使用中括号添加元素，相当于Java Map 的 put(key,value)方法
colors.yellow = '#FFFF00'// 使用点表达式添加元素
assert colors.pink == '#FF00FF'
assert colors['yellow'] == '#FFFF00'
assert colors instanceof java.util.LinkedHashMap // 默认使用LinkedHashMap类型

// Groovy Map的key默认语法不支持变量，这里的key时间上是字符串'keyVal'而不是keyVal变量的值'name'
def keyVal = 'name'
def persons = [keyVal: 'Guillaume']
assert !persons.containsKey('name')
assert persons.containsKey('keyVal')

//要使用变量作为key，需要使用括号
def keyVal1 = 'name'
def persons1 = [(keyVal): 'Guillaume']
assert persons.containsKey('name')
assert !persons.containsKey('keyVal')
