package game.action;

public class Action 
{
    public static final int CREATE_GAME         = 1;   // Создать игру
    public static final int CONNECT_SESSIONS    = 2;   // Присоединиться к игре
    public static final int PUT_CARDS           = 3;   // Положить карту на стол
    public static final int FIND_CARDS          = 4;   // Узнать, как пошёл соперник
    public static final int WAITING_CONNECTION  = 5;   // Ожидание подключения
    public static final int SESSION_DATA_INITAL = 6;   // Получения начальных данных 
    public static final int BUT_CARDS           = 7;   // Отбить карту
    public static final int I_TAKE_CARD         = 8;   // Взять карты
    public static final int BEAT_CARD           = 9;   // Бита
    public static final int UPDATE_DATA         = 10;   // Обновление данных
}
