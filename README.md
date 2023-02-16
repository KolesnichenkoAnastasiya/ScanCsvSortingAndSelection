Задание.
Тестовое задание по считыванию данных из файла, их сортировке и поиску. 

Дан файл "Задача ВС Java Сбер.csv" из которого нужно считать данные в модель содержащую 
данные поля: namе, region, district, population, foundation.

Необходимо осуществить следующую сортировку и вывести данные на консоль:
• Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра;

• Сортировка по федеральному округу по убыванию и наименованию города внутри округа по убыванию с учетом регистра;

• Сортировка по федеральному округу по убыванию и наименованию города внутри округа в алфавитном порядке с учетом регистра.

Найти:
город с максимальной численностью в виде:

[489] = 11514330;

количество городов в разрезе региона в виде:

• Адыгея - 2

• Алтай - 1

• Алтайский край - 12

                 Реализация.
Сканирование файлов реализовано в пакете java.scaner с использованием java.util.Scanner и класса City (java.model.City), данные сохраняются в ArrayList.

При помощи java.service.ArrayService считанные данные преобразуются в массив объектов. Методы для сортировки реализованы в java.service.SortService:

• sortByCityNameDesc - cортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра;

• sortByDistrictDescAndNameDesc - cортировка по федеральному округу по убыванию и наименованию города внутри округа по убыванию с учетом регистра;

• sortByDistrictDescAndNameAbc - сортировка по федеральному округу по убыванию и наименованию города внутри округа в алфавитном порядке с учетом регистра;

• sortByPopulation - город с максимальной численностью;

• citiesInTheRegion - количество городов в разрезе региона.

Реализовано автоматическое тестирование кода в service.SortServiceTest с помощью JUNIT 4.12
