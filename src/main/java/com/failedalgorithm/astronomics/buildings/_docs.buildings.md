# Buildings
All buildings inherit from the buildings parent class.

There are two main types of buildings: simple and advanced. 
- Simple buildings do not require any inputs or consume
any resources to produce an Item.
- Advanced Buildings do require inputs and do consume resources
  to produce Items

All buildings are hosted on a single table. Simple buildings
do not override any methods of the base Building class.

## Building Types
The Building Type class is just a container to hold
building stats. 