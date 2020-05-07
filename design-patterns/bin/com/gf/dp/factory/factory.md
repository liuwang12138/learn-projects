###简单工厂
- 扩展性并不好
###工厂方法
- 产品维度进行扩展
- 每种产品对应一个工厂
- 就是生产某一种产品的抽象工厂

Factory			->		Movable
CarFactory 		-> 		Car
PlaneFactory 	-> 		Plane

###抽象工厂
- 任意定制产品族
- 抽象的工厂、具体的工厂、抽象的产品、具体的产品

Food				printName()
	Bread
	Mushroom																				
vehicle				go()
	Car
	Plane
weapon				shoot()
	AK47 implements weapon
	MagicStick 

AbstractFactory
- createFood()
- createVehicle()
- createWeapon()
