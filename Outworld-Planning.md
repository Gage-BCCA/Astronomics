# User

Holds information about the actual person playing the game.

	- UUID: Used for authenticating requests
	- Username: Generic information

	Methods:
	create()
	GET /user/create
	Create new user entry

# World

Base container for the Outerworld instance

	- ID: The identifier
	- Name: Planet Name

	Methods:
	not callable by client
	generate()
	creates 225 zones that have 100 plots with randomized resources. Create one main DMZ in the middle. Persisted in the database.

Worlds will have a 15x15 grid of ```Zones``` that are filled by colonies, markets, etc.

# Zone

Base Container for a specific grid point in a world

	- ID
	- World ID: reference to parent world
	- X: x coord
	- Y: y coord
	- type: COLONY, DMZ, REFINERY, etc...
		- Can be informational, or may be used to influence available actions to take on the zone
	- occupied: true/false
	- name: randomly generated name for zone

	Methods:
	scan()
	/zone/scan
	return a brief summary of the zone and all the plots

Zones have a 20x20 grid of indiviual ```Plot``` objects that are utilized by User created colonies

quick note: look up @Supermappedclass and DiscriminatorColumn for Spring API to create child classes based on type

# Plot

Plots are individual pieces of land that a colony will use to build, farm, and utilize

	- ID
	- Zone ID
	- X
	- Y
	- occupied: boolean
	- has_metal: boolean
	- has_wood: boolean
	- is_fertile: boolean
	- is_water: boolean

# Colony

Colonies are the main point of interaction that a player will have. Contains generic stats.

	- ID
	- Zone ID
	- Name
	- Food Consumption

	- Raw Food Qty
	- Refined Food Qty

	- Raw Metals Qty
	- Refined Metal Qty

	- Raw Wood Qty
	- Refined Wood Qty

	- Raw Stone Qty
	- Refined Stone Qty

	- Electricity Demand: measured in arbitrary units
	- Electricity Production

	- Credits
		- Money

	Methods:
		found()
		POST /colony
		check if Zone if occupied, occupy zone with player, take name of colony, start with base amount of resources

# Building

Parent class of all building types that will be places on a ```Plot```. Has storage amount.

	- ID
	- Colony ID
	- Plot ID
	- Type
		- Will be used to construct possible actions
		- LOGGER_CAMP
		- WAREHOUSE
		- MINING_DRILL
		- etc.

	- Name
		- Will be used to make requests to this building more friendly

	- Food consumption
	- Electricity Consumption

	- is_built: boolean
	- is_active: boolean

	- Resource type ID: identifies the resource type that building produces
	- max_storage: the total amount of resources that can be stored
	- current_storage: the current amount in storage
	- craft_speed: amount of resources created per "tick"
	- last_produced_at: the timestamp of the last time produce() was called
	- maximum_singular_produce_run: the most of queued resources that can be gathered at once



	Methods:
		Meta:
			rename() - HTTP PUT - rename building
			destroy()- HTTP DELETE - remove building, set plot to unoccupied
		Info:
			summary() - HTTP GET - return building summary
		In-Game:
			Creation:
				establish() - HTTP POST - set plot to occupied, set all non-relevant resources available to false, leave building type empty
				build() - HTTP POST - check if resources required for building are present, set plot to occupied, construct building, set all non-relevant resources available to false
			Resources:	
				- dump()- HTTP GET - removes all stored resources
						GET colony/{colonyId}/buildings/{id}/dump
						0. Get Target building
						1. Remove any entry in the stored items table

				- transport(warehouse name, long amt) - HTTP POST - stores specified resources in specified building
					- Request Example:
						POST colony/{colonyId}/buildings/{id}/transport
						{
							"UUID": user UUID,
							targetBuildingName: "Warehouse-Alpha1",
							resources : [
								{
									"resourceName": BASE_METAL,
									"amt": 100 
								},
								{
									"resourceName": BASE_STONE,
									"amt": 25
								}
							]
						}
					- Steps:
						0. Fetch both origin and target buildings
							0a. throw error if either one doesnt exist
						1. Check if origin has resources
							1a. throw error if not enough
						2. Check if target can hold resources
							2a. throw error if it goes over maximum
						3. Subtract from origin
						4. updated stored_items table

				- transportAll(warehouseName)- HTTP POST - attempts to store all resources in specified building
							POST /colony/{colonyId}/buildings/{id}/transport-all
							{
								"UUID": user UUID,
								buildingName: "Alpha1"
							}



				- produce()- HTTP GET - (current time - last_produced_at in seconds * craft_speed) added to items stored in building if < maximum_singular_produce_run
							POST /colony/{colonyId}/building/{id}/produce
							0. Get target building
								0a. error if doesn't exist
							1. Calculate amount produced
							2. Update items stored table
								2a. return message saying resources gathered
									2a.a. add message saying if excess resources were wasted

The building occupies and overrides any non-relevant resource on the plot. A Mining drill constructed on a
fertile piece of land that also has wood, will have neither of those resources avialable anymore.

quick note: look up @Supermappedclass and DiscriminatorColumn for Spring API to create child classes based on type

## Mining Drill - Basic Building

Generates raw metal resources for the colony. Has all the props of a building plus:

## Farm Plot - Basic Building

Generates raw food resources for the colony

## Logger Camp - Basic Building

Generates raw lumber

## Warehouse

Has lots of storage capacity. Produces nothing.

## Smelter

Refines metal

## Woodyard

Refines wood

## Industrial Kitchen

Refines Food

## Masonyard

Refines Stone

## Solar Farm

Produces Power Cells directly

# Advanced Buildings

Advanced buildings still inherit from the building parent class, but overwrite the produce() method. Any building that
takes in inputs to create an item
is considered an advanced building.

# Item

A generic item that buildings produce and store

	- ID
	- Name
	- Base Value
	- Type
	- Unit Size: how much storage it takes up

# Jobs

All actions generate a job that takes some time.

    - ID
    - Created At
    - Time Required
    - End Time
    - Job Type
    - Target Type
    - Target X_coord
    - Target Y_coord

Example:
Job:
- ID: 1
- Time Required: 2 minutes (dynamically generated based on distance and job)
- Start time: Creation time
- end time: start time + time required
- Job type: MOVE RESOURCES
- Target Type: Building
- Target Type: 001
- Target X: 15
- Target Y: 25
- Job Origin X: 0
- Job Origin Y: 0
Job_Resources:
- Item ID: 15
- Job ID: 1
- Amt: 250

Job_type dynamically generates the MoveResources class using the inheritance and
discriminator value

```
Job object - Dynamically assigned the MoveResources Class because the discriminator value
was MOVE_RESOURCES

private JobType = new MoveResourcesObject(
    *insert all information*
)
```

```
MoveResources.java
public class MoveResources extends JobType:

    @override
    public void execute() {
    // get target building via the ID
    // Make sure that the building has the required resources in the job_items table
        // fail out if not
    // Transfer resources from old building to new building
        // if of course the new building can hold them
    // change job status to completed 
    }
```

```
ScheduledTask

// iterate every job
    // if status is COMPLETE, archive
// Construct job types
// Call execute
```

Jobs will be stored in the Jobs table, which will act as a queue. Every few minutes
the server will iterate this queue, execute the jobs, and archive them in the JobHistory
table.