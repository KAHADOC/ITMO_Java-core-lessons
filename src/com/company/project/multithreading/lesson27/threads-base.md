1. Потоки и их создание
2. Методы потоков
3. Группы потоков и их методы

### Потоки и их создание

1. После запуска программы и создания процесса в ОС, создается основной поток выполнения программы, начинается
   последовательное выполнение инструкций.

2. После создания основного потока можно запускать другие потоки, тогда инструкции процесса будут выполняться
   параллельно или псевдопараллельно (процессор будет переключаться между живыми потоками)

3. Одно ядро процессора может обрабатывать один поток

4. Поток всегда представлен экземпляром класса `Thread`

5. Состояние потока:
    1) `NEW` - поток создан (создан экземпляр класса Thread), но не запущен.
    2) `RUNNABLE` - поток запущен, выполняются инструкции run метода (время запуска потока определяет 'планировщик
       потоков' после вызова метода start у экземпляра потока)
    3) `BLOCKED` - ожидает права на монитор объекта
    4) `WAITING` - ожидает, пока другой поток выполнит определенные действия (может перейти в статус после вызова
       методов wait и join без временных ограничений, останавливающих механизмов из пакета java.util.concurrent)
    5) `TIMED_WAITING` - ожидает, пока другой поток выполнит определенные действия или истечет указанное время (может
       перейти в статус после вызова методов wait и join с временными ограничениями, метода sleep, останавливающих
       механизмов из пакета java.util.concurrent)
    6) `TERMINATED` - поток завершил работу

6. Создание потоков, инструкции потоков и их выполнение:
    1) Создать класс, который наследуется от класса Thread. Переопределить метод `void run()` для описания инструкций,
       которые
       должны выполняться в отдельном потоке. Тогда создание и запуск потока будет выглядеть следующим образом:

            ThreadChild thread = new ThreadChild(); // экземпляр потока
            thread.start(); // передать планировщику для запуска

    2) Создать класс, который реализует интерфейс Runnable. Инструкции, которые должен выполнять поток описываются в
       методе
       описать в методе `void run()`. Экземпляр Runnable типа можно создать через лямбда выражение или отдельный класс.
       Тогда создание и запуск потока будет выглядеть следующим образом:

            Runnable task01 = () -> { инструкции потока }; // задачи для потока через лямбда
            Thread thread01 = new Thread(task01); // экземпляр потока
            thread01.start(); // передать планировщику для запуска

            Runnable task02 = new RunnableTask(); // задачи для потока через обычные класс и об
            Thread thread02 = new Thread(task02); // экземпляр потока
            thread02.start(); // передать планировщику для запуска

    3) Воспользоваться возможностями пакета java.util.concurrent.*: например, пулом потоков, Callable и Future типами

### Методы потоков (методы класса Thread)

`Static` методы:

1. `Thread.currentThread()` - ссылка на текущий поток.
2. `Thread.yield()` - сигнал переключить процессор на другой поток (выполнение зависит от планировщика).
3. `Thread.onSpinWait()` - (начиная с java 9) сигнал переключить процессор на другой поток, без вывода потока из
   очереди, затрачивает меньше ресурсов, чем `Thread.yield()`.
4. `Thread.sleep(long mls)` - приостанавливает поток на "mls" миллисекунд.
5. `Thread.sleep(long mls, int nanos)` - приостанавливает поток на "mls" миллисекунд + nanos наносекунд.

Возобновление работы уснувших потоков зависит от точности системных таймеров и планировщиков. Поток не теряет
существующие права на мониторы. `InterruptedException` будет выброшена - если во время действие sleep будет вызван метод
interrupt(),
исключение приведет к сбросу значения свойства interrupted на false.

6. `Thread.activeCount()` - вернет количество живых потоков группы текущего потока.
7. `Thread.enumerate(Thread[] forThreads)` - помещает в массив `forThreads` живые потоки группы.

`Non-Static` методы:

1. `State getState()` - возвращает текущий статус потока.
2. `boolean isAlive()` - возвращает поток, если он жив (не завершил работу).
3. `void setName(String name)` - присваивает потоку имя `name` (например, для отладки).
4. `String getName()` - возвращает имя потока (например, для отладки).
5. `long getId()` - возвращает уникальный идентификатор потока. ID генерируется при создании экземпляра потока.
6. `void setPriority(int value)` - устанавливает приоритет запуска потока. `value` должно быть в диапазоне от
   `Thread.MIN_PRIORITY` до `Thread.MAX_PRIORITY` (если поток принадлежит группе, максимальный приоритет потока не может
   быть выше максимального приоритета группы).
7. `int getPriority()` - возвращает текущий приоритет потока.
8. `void setDaemon(boolean value)` - сделать поток фоновым (`value == true`). Метод можно вызывать до запуска потока.
9. `boolean isDaemon()` - вернет true, если поток является фоновым.
10. `void run()` - содержит инструкции, которые выполняет поток при запуске. Должен вызываться планировщиком. Если
    вызвать в коде, инструкции не будут выполняться в отдельном потоке.
11. `void start()` - передать поток планировщику для запуска, планировщик помещает поток в очередь, когда очередь
    доходит до него (потока), вызывается метод run, инструкции начинают выполняться в отдельном потоке.
12. `join(long millis)` - вызывающий поток ожидает завершения потока, у которого вызван join, в течение `millis`
    миллисекунд, потом продолжает работу.
13. `join(long millis, int nanos)` - вызывающий поток ожидает завершения потока, у которого вызван join, в
    течение `millis` миллисекунд + `nanos` наносекунд, потом продолжает работу.
14. `join()` - вызывающий поток бесконечно ожидает завершения потока, у которого вызван join. Аналогичен
    вызовам `join(0)` и `join(0, 0)`.

            // поток main

            Thread other01 = new Thread(() -> {});
            Thread other02 = new Thread(() -> {});
            other01.start();
            other02.start();

            other01.join(1000); // main поток приостанавливает работу и ждет завершения other01 потока,
            // если other01 поток не завершит работу за 1000 млс, main поток продолжит работу
            other02.join(); // main поток приостанавливает работу и бесконечно ждет завершения other02 потока 


15. `void interrupt()` - меняет значение свойства `interrupted` на `true`. Используется в механизме завершения работы
    потока.
16. `boolean isInterrupted()` - возвращает значение свойства `interrupted`. Используется в механизме завершения работы
    потока.
17. `ThreadGroup getThreadGroup()` - возвращает ссылку на группу, которой принадлежит поток.

### Механизм завершения работы потоков

Метод `void stop()` не используется для остановки потока, так как считается небезопасным. Других методов для остановки
потока не существует.

Завершение потока происходит в следующих ситуациях:

1. если выброшено необработанное исключение;
2. остановилась jvm;
3. поток является фоновым и все потоки, не являющиеся фоновыми завершили работу;
4. все инструкции потока выполнены.

Механизм завершения работы потоков должен сводиться к реализации п.4.

Свойства и методы, участвующие в реализации данного механизма:

1. свойство `boolean interrupted` - изначально в значении `false`;
2. метод `boolean isInterrupted()` - возвращает значение свойства `interrupted`;
3. метод `void interrupt()` - меняет значение свойства `interrupted` на `true` (не останавливает поток, просто меняет
   значение свойства).

                 Thread thread = new Thread(()->{ 
                    while (!Thread.currentThread().isInterrupted()) {
                        // инструкции потока

                        try {
                            Thread.sleep(1000); // или другой функционал, заставляющий поток ждать
                        } catch (InterruptedException e) { // InterruptedException - если метод interrupt() будет вызван, 
                                                           //  когда поток находится в состоянии ожидания
                            // InterruptedException сбрасывает значение свойства interrupted на false.  
                            // Если возобновление работы потока при исключении не предполагается, 
                            // необходимо снова вызвать метод interrupt()
                            Thread.currentThread().interrupt();
                        }
                    }
                 });
                 thread.start(); // передача планировщику и последующий запуск потока
                 // цикл в методе run начинает работать

                 // метод вызывается в зависимости от логики программы
                 thread.interrupt(); // interrupted = true, цикл в методе run потока завершает работу, 
                                     // так как условие while(!Thread.currentThread().isInterrupted()) становится false. 
                                     // Поток завершает работу, так как выполнены все инструкции.

### Группы потоков и их методы

1. Группы - экземпляры `ThreadGroup` используются для управления несколькими потоками.
2. Можно выстраивать иерархию групп.
3. Методы групп потоков:
    1) `String getName()` - возвращает имя группы потока (например, для отладки).
    2) `ThreadGroup getParent()` - возвращает ссылку на группу-родителя.
    3) `void setMaxPriority(int value)` - устанавливает приоритет запуска всех потоков группы. `value` должно быть в
       диапазоне от `Thread.MIN_PRIORITY` до `Thread.MAX_PRIORITY`. Если поток принадлежит группе, максимальный
       приоритет потока не может быть выше максимального приоритета группы.
    4) `int getMaxPriority()` - возвращает максимально возможный приоритет для потоков группы.
    5) `boolean parentOf(ThreadGroup group)` - возвращает true, если `group` - родитель текущей группы.
    6) `int activeCount()`- возвращает количество живых потоков в группе.
    7) `int enumerate(Thread[] forThreads)` - помещает в массив `forThreads` живые потоки группы.
    8) `int activeGroupCount()` - возвращает количество живых групп в группе.
    9) `void interrupt()` - меняет значение свойства `interrupted` каждого потока группы на `true`. Используется в
       механизме завершения работы потока.
    10) `void setDaemon(boolean value)` - ***устаревший с 16 версии***, делает все потоки группы
        фоновыми (`value == true`).
    11) `boolean isDaemon()` - ***устаревший с 16 версии***, возвращает true, если все потоки группы являются фоновыми.
    12) `boolean isDestroyed()` - ***устаревший с 16 версии***, возвращает true, если все потоки группы завершены.
    13) `void destroy()` - ***устаревший с 16 версии***, расформировывает группу и ее подгруппы.