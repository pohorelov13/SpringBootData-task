1. ��������� ���� Order. ��� ���� ���������� ��������: id, date, cost, products

1.1 ������ �� �������� �� ��������� JPA-��������.

2. ��������� ���� Product. ��� ���� ���������� ��������: id, name, cost

2.1 ������ �� �������� �� ��������� JPA-��������.

3. ������� ProductRepository ��� �����䳿 � �������� Product

4. ���������� ������ ���������� � ��������������� ����-��������� OrderRepository

5. ������������� Spring-������� ����� application.yml

6.1 ������� ��������� �� URL: http://localhost:8080

6.2 ���������� ��������� �� ���� INFO ��� ������ �������� �� ��� ������ org.springframework.web

������ ��������� ������ ��������� � ������� �� ����� � ����

7. ��������� OrderService ���� ���� ��������� � OrderRepository �� ������������ ��������: ��������� �� id, ��������� ���, ���������, ��������� .