import sys
import datetime
from operator import itemgetter

STAGE1_FILE_IN = "BandB_1.txt"
STAGE2_FILE_IN = "BandB_2.txt"
STAGE3_FILE_IN = "BandB_3.txt"
STAGE4_FILE_IN = "BandB_4.txt"
STAGE5_FILE_IN = "BandB_5.txt"
STAGE6_FILE_IN = "BandB_6.txt"

#################################################################
# Utility functions
#################################################################
def handle_commands(bedroom_list: 'list of bedrooms', reservation_list: 'list of reservations',
                    reservation_counter:int) -> ('list of bedrooms', 'list of reservations',int):
    readfile = input("File to read from: ")
    st1_file= open(readfile, 'r')
    file_data= st1_file.read().splitlines()
    st1_file.close()

    for line in file_data:
        stripped = line.strip()
        cmd = stripped[0:2].upper()
        if cmd == '**':
            continue
        elif cmd == 'AB':
            room_num=int(stripped[3:])
            bedroom_list = add_bedroom(bedroom_list,room_num)
        elif cmd == 'BD':
            room_num=int(stripped[3:])
            bedroom_list, reservation_list = delete_bedroom(bedroom_list,reservation_list,room_num)
        elif cmd == 'BL':
            print_bedrooms(bedroom_list)
        elif cmd == 'NR':
            reservation_list, reservation_counter = make_reservation(bedroom_list, reservation_list,
                                                                     reservation_counter, stripped)
        elif cmd == 'RL':
            print_reservations(reservation_list)
        elif cmd == 'RD':
            reserve_num=int(stripped[3:])
            reservation_list = delete_reservation(reservation_list,reserve_num)
        elif cmd == 'RB':
            room_num = int(stripped[3:])
            print_reservation_by_bedroom(reservation_list, room_num)
        elif cmd == 'RC':
            guest = stripped[3:]
            print_reservation_by_guest(reservation_list, guest)
        elif cmd == 'LA':
            arrival = stripped[3:]
            print_by_arrival_date(reservation_list, arrival)
        elif cmd == 'LD':
            departure = stripped[3:]
            print_by_departure_date(reservation_list, departure)
        elif cmd == 'LF':
            dates = stripped[3:]
            print_free_bedrooms(bedroom_list,reservation_list,dates)
        elif cmd == 'LO':
            dates = stripped[3:]
            print_occupied_bedrooms(bedroom_list, reservation_list, dates)
        elif cmd == 'PL':
            print(stripped[3:])
        else:
            print ('Error: Unknown command')
            sys.exit(1)

    return bedroom_list, reservation_list, reservation_counter

def add_bedroom(BL:'list of bedrooms', room_num:int)-> 'list of bedrooms':
    '''Return a list of bedrooms
    '''
    if room_num in BL:
        print("Sorry, can't add room %d again; it's already on the list." % (room_num))
        return BL
    else:
        BL.append(room_num)
        return BL

def delete_bedroom(BL:'list of bedrooms', RL: 'list of reservations',
                   room_num:int) ->('list of bedrooms','list of reservations'):
    '''Return a list of bedrooms
    '''
    if room_num in BL:
        #check for existing reservations for this room
        newRL = []
        for rooms in RL: #check if room is already in reservation list
            if rooms["room_num"] == room_num:
                print("Deleting room %d" % (room_num) + " forces cancelation of this reservation:")
                print("    %s arriving %s and departing %s (Conf. #%d)" % (rooms["guest"],
                                                                           rooms["arrive"].strftime('%m/%d/%Y'),
                                                                           rooms["depart"].strftime('%m/%d/%Y'),
                                                                           rooms["no"]))
            else:
                newRL.append(rooms)
        BL.remove(room_num)
        return BL, newRL
    else:
        print("Sorry, can't delete room %d; it is not in service now" % (room_num))
        return BL, RL

def make_reservation(BL:'list of bedrooms', RL:'list of reservations', reserve_num:int,
                     input_str:str) -> ('list of reservations','reserve_num'):
    #split input string
    split = input_str.split(' ')
    split2 = [x for x in split if x] #remove empty strings (extra spaces)
    room_num=int(split2[1])

    if room_num in BL: #check that room to reserve is in service (in BL)
        reservation = {}

        reservation["no"] = reserve_num+1 #don't reuse confirmation numbers even if deleted
        reservation["room_num"] = room_num

        arrive=split2[2].split("/") #split date string on /
        arrive=datetime.date(int(arrive[2]),int(arrive[0]),int(arrive[1]))
        reservation["arrive"] = arrive

        depart=split2[3].split("/")
        depart=datetime.date(int(depart[2]),int(depart[0]),int(depart[1]))
        reservation["depart"] = depart

        if arrive > depart: #can't arrive after departure date
            print("Sorry, can't reserve room %d" % (room_num) + " (" + arrive.strftime('%m/%d/%Y')
                  + " to " + depart.strftime('%m/%d/%Y') + ");")
            print("    can't leave before you arrive.")
            return RL, reserve_num
        elif arrive == depart: #can't arrive and leave on same day
            print("Sorry, can't reserve room %d" % (room_num) + " (" + arrive.strftime('%m/%d/%Y')
                  + " to " + depart.strftime('%m/%d/%Y') + ");")
            print("    can't arrive and leave on the same day.")
            return RL, reserve_num
        else:
            for rooms in RL: #check if room is already in reservation list
                if rooms["room_num"] == room_num: #check for dates
                    if (depart < rooms["depart"] and depart > rooms["arrive"]) \
                            or (arrive > rooms["arrive"] and arrive < rooms["depart"]) \
                            or (rooms["depart"] == depart and rooms["arrive"] == arrive):
                        print("Sorry, can't reserve room %d" % (room_num) + " (" + arrive.strftime('%m/%d/%Y')
                            + " to " + depart.strftime('%m/%d/%Y') + ");")
                        print("    it's already booked (Conf. #%d)" % (rooms["no"]))
                        return RL, reserve_num
                else:
                    continue

            #continues only if room not found in reservation list or dates not overlapping with existing reservation
            guest=" ".join(split2[4:])
            reservation["guest"] = guest

            print("Reserving room %d for %s -- Confirmation #%d" % (room_num, guest, reservation["no"]))
            print("     (arriving", arrive.strftime('%m/%d/%Y')+", departing "
                  +depart.strftime('%m/%d/%Y')+")")
            RL.append(reservation)
            return RL, reserve_num+1
    else:
        print("Sorry; can't reserve room %d; room not in service" % (room_num))
        return RL, reserve_num

def delete_reservation(RL: 'list of reservations', reserve_num:int) -> 'list of reservations':
    for rooms in RL:
        if rooms["no"] == reserve_num:
            RL.remove(rooms)
            return RL
        else:
            continue
    print("Sorry, can't cancel reservation; no confirmation number %d" % (reserve_num))
    return RL

def print_bedrooms(BL: 'list of bedrooms')-> None:
    '''Prints a list of bedrooms
    '''
    print ('Number of bedrooms in service: ', len(BL))
    print ('-'*36)
    BL.sort() #sort bedroom list for printing
    for room in BL:
        print (room)

def print_reservations(RL:'list of reservations')-> None:
    print("Number of reservations:  %d" % (len(RL)))
    print("No. Rm. Arrive     Depart     Guest")
    print('-'*50)
    RL = sorted(RL, key=itemgetter('arrive')) #sort reservations by arrival date
    for rooms in RL:
        print('{:3d} {:3d} {:10s} {:10s} {:20s}'.format(rooms["no"], rooms["room_num"],
                                                        rooms["arrive"].strftime('%m/%d/%Y'),
                                                        rooms["depart"].strftime('%m/%d/%Y'),
                                                        rooms["guest"]))

def print_reservation_by_bedroom(RL:'list of reservations', room_num:int) -> None:
    print("Reservations for room %d" % (room_num))
    for rooms in RL:
        if rooms["room_num"] == room_num:
            print('  {:10s} to {:10s}:  {:20s}'.format(rooms["arrive"].strftime('%m/%d/%Y'),
                                                       rooms["depart"].strftime('%m/%d/%Y'),rooms["guest"]))

def print_reservation_by_guest(RL: 'list of reservations', guest: str) -> None:
    print("Reservations for %s" % (guest))
    for rooms in RL:
        if rooms["guest"] == guest:
            print('  {:10s} to {:10s}:  room {:3d}'.format(rooms["arrive"].strftime('%m/%d/%Y'),
                                                           rooms["depart"].strftime('%m/%d/%Y'),
                                                           rooms["room_num"]))

def print_by_arrival_date(RL: 'list of reservations', arrive: str) -> None:
    arrival=arrive.split("/") #split date string on /
    arrival=datetime.date(int(arrival[2]),int(arrival[0]),int(arrival[1]))
    print("Guests arriving on " + arrival.strftime('%m/%d/%Y') + ":")
    for rooms in RL:
        if rooms["arrive"] == arrival:
            print('  {:s} (room {:3d})'.format(rooms["guest"], rooms["room_num"]))

def print_by_departure_date(RL: 'list of reservations', departure: str) -> None:
    depart=departure.split("/") #split date string on /
    depart=datetime.date(int(depart[2]),int(depart[0]),int(depart[1]))
    print("Guests departing on " + depart.strftime('%m/%d/%Y') + ":")
    for rooms in RL:
        if rooms["depart"] == depart:
            print('  {:s} (room {:3d})'.format(rooms["guest"], rooms["room_num"]))

def print_free_bedrooms(BL: 'list of bedrooms', RL: 'list of reservations', dates: str) -> None:
    arrive = dates.split(" ")[0]
    departure = dates.split(" ")[1]
    arrival=arrive.split("/") #split date string on /
    arrival=datetime.date(int(arrival[2]),int(arrival[0]),int(arrival[1]))
    depart=departure.split("/") #split date string on /
    depart=datetime.date(int(depart[2]),int(depart[0]),int(depart[1]))

    print("Bedrooms free between " + arrival.strftime('%m/%d/%Y') + " to " + depart.strftime('%m/%d/%Y') + ":")
    for bedroom in BL:
        in_RL = 0
        for rooms in RL:
            if rooms["room_num"] == bedroom: #reservation exists
                if (depart < rooms["depart"] and depart > rooms["arrive"]) \
                        or (arrival > rooms["arrive"] and arrival < rooms["depart"]) \
                        or (rooms["depart"] == depart and rooms["arrive"] == arrival):
                    #if there is a reservation that overlaps
                    in_RL += 1
        if in_RL == 0:
            #print room number only if no reservation or no overlapping reservation with dates
            print("  {:3d}".format(bedroom))

def print_occupied_bedrooms(BL: 'list of bedrooms', RL: 'list of reservations', dates: str) -> None:
    arrive = dates.split(" ")[0]
    departure = dates.split(" ")[1]
    arrival=arrive.split("/") #split date string on /
    arrival=datetime.date(int(arrival[2]),int(arrival[0]),int(arrival[1]))
    depart=departure.split("/") #split date string on /
    depart=datetime.date(int(depart[2]),int(depart[0]),int(depart[1]))

    print("Bedrooms occupied between " + arrival.strftime('%m/%d/%Y') + " to " + depart.strftime('%m/%d/%Y') + ":")
    for bedroom in BL:
        in_RL = 0
        for rooms in RL:
            if rooms["room_num"] == bedroom: #reservation exists
                if (depart < rooms["depart"] and depart > rooms["arrive"]) \
                        or (arrival > rooms["arrive"] and arrival < rooms["depart"]) \
                        or (rooms["depart"] == depart and rooms["arrive"] == arrival):
                    #if there is a reservation that overlaps
                    in_RL += 1
        if in_RL > 0:
            #print room number if there is at least 1 reservation with overlapping dates
            print("  {:3d}".format(bedroom))

def generate_file_content(BL: 'list of bedrooms', RL: 'list of reservations') -> str:
    write_str = ''
    for bedrooms in BL:
        write_str += "AB {:3d}\n".format(bedrooms)
    for rooms in RL:
        write_str += "NR {:3d} {:10s} {:10s} {:s}\n".format(rooms["room_num"],rooms["arrive"].strftime('%m/%d/%Y'),
                                                            rooms["depart"].strftime('%m/%d/%Y'),rooms["guest"])
    return write_str

#################################################################
# Stage I
#################################################################
'''
def stage1():
               
    st1_file= open(STAGE1_FILE_IN, 'r')
    file_data= st1_file.read().splitlines()
    st1_file.close()
    
    bedroom_list=[]

    for line in file_data:
        stripped = line.strip()
        cmd = stripped[0:2].upper()
        if cmd == '**':
            continue
        elif cmd == 'AB':
            room_num=int(stripped[3:])
            bedroom_list = add_bedroom(bedroom_list,room_num) 
        elif cmd == 'BL':
            print_bedrooms(bedroom_list)
        elif cmd == 'PL':
            print(stripped[3:])
        else:
            print ('Error: Unknown command')
            sys.exit(1)
            
print ("\n##### Stage I #####\n")
stage1()
'''
#################################################################
# Stage II
#################################################################
'''
def stage2():
    st1_file= open(STAGE2_FILE_IN, 'r')
    file_data= st1_file.read().splitlines()
    st1_file.close()

    bedroom_list=[]

    for line in file_data:
        stripped = line.strip()
        cmd = stripped[0:2].upper()
        if cmd == '**':
            continue
        elif cmd == 'AB':
            room_num=int(stripped[3:])
            bedroom_list = add_bedroom(bedroom_list,room_num)
        elif cmd == 'BD':
            room_num=int(stripped[3:])
            bedroom_list = delete_bedroom(bedroom_list,room_num)
        elif cmd == 'BL':
            print_bedrooms(bedroom_list)
        elif cmd == 'PL':
            print(stripped[3:])
        else:
            print ('Error: Unknown command')
            sys.exit(1)

print ("\n### Stage II ###\n")
stage2()
'''
#################################################################
# Stage III
#################################################################
'''
def stage3():
    st1_file= open(STAGE3_FILE_IN, 'r')
    file_data= st1_file.read().splitlines()
    st1_file.close()

    bedroom_list=[]
    reservation_list=[]

    for line in file_data:
        stripped = line.strip()
        cmd = stripped[0:2].upper()
        if cmd == '**':
            continue
        elif cmd == 'AB':
            room_num=int(stripped[3:])
            bedroom_list = add_bedroom(bedroom_list,room_num)
        elif cmd == 'BD':
            room_num=int(stripped[3:])
            bedroom_list = delete_bedroom(bedroom_list,room_num)
        elif cmd == 'BL':
            print_bedrooms(bedroom_list)
        elif cmd == 'NR':
            reservation_list = make_reservation(bedroom_list, reservation_list, stripped)
        elif cmd == 'RL':
            print_reservations(reservation_list)
        elif cmd == 'RD':
            reserve_num=int(stripped[3:])
            reservation_list = delete_reservation(reservation_list,reserve_num)
        elif cmd == 'PL':
            print(stripped[3:])
        else:
            print ('Error: Unknown command')
            sys.exit(1)


print ("\n### Stage III ###\n")
stage3()
'''
#################################################################
# Stage IV
#################################################################
'''
def stage4():
    st1_file= open(STAGE4_FILE_IN, 'r')
    file_data= st1_file.read().splitlines()
    st1_file.close()

    bedroom_list=[]
    reservation_list=[]
    reservation_counter = 0

    for line in file_data:
        stripped = line.strip()
        cmd = stripped[0:2].upper()
        if cmd == '**':
            continue
        elif cmd == 'AB':
            room_num=int(stripped[3:])
            bedroom_list = add_bedroom(bedroom_list,room_num)
        elif cmd == 'BD':
            room_num=int(stripped[3:])
            bedroom_list, reservation_list = delete_bedroom(bedroom_list,reservation_list,room_num)
        elif cmd == 'BL':
            print_bedrooms(bedroom_list)
        elif cmd == 'NR':
            reservation_list, reservation_counter = make_reservation(bedroom_list, reservation_list, reservation_counter, stripped)
        elif cmd == 'RL':
            print_reservations(reservation_list)
        elif cmd == 'RD':
            reserve_num=int(stripped[3:])
            reservation_list = delete_reservation(reservation_list,reserve_num)
        elif cmd == 'PL':
            print(stripped[3:])
        else:
            print ('Error: Unknown command')
            sys.exit(1)


print ("\n### Stage IV ###\n")
stage4()
'''
#################################################################
# Stage V
#################################################################      
'''
def stage5():
    st1_file= open(STAGE5_FILE_IN, 'r')
    file_data= st1_file.read().splitlines()
    st1_file.close()

    bedroom_list=[]
    reservation_list=[]
    reservation_counter = 0

    for line in file_data:
        stripped = line.strip()
        cmd = stripped[0:2].upper()
        if cmd == '**':
            continue
        elif cmd == 'AB':
            room_num=int(stripped[3:])
            bedroom_list = add_bedroom(bedroom_list,room_num)
        elif cmd == 'BD':
            room_num=int(stripped[3:])
            bedroom_list, reservation_list = delete_bedroom(bedroom_list,reservation_list,room_num)
        elif cmd == 'BL':
            print_bedrooms(bedroom_list)
        elif cmd == 'NR':
            reservation_list, reservation_counter = make_reservation(bedroom_list, reservation_list, reservation_counter, stripped)
        elif cmd == 'RL':
            print_reservations(reservation_list)
        elif cmd == 'RD':
            reserve_num=int(stripped[3:])
            reservation_list = delete_reservation(reservation_list,reserve_num)
        elif cmd == 'RB':
            room_num = int(stripped[3:])
            print_reservation_by_bedroom(reservation_list, room_num)
        elif cmd == 'RC':
            guest = stripped[3:]
            print_reservation_by_guest(reservation_list, guest)
        elif cmd == 'LA':
            arrival = stripped[3:]
            print_by_arrival_date(reservation_list, arrival)
        elif cmd == 'LD':
            departure = stripped[3:]
            print_by_departure_date(reservation_list, departure)
        elif cmd == 'LF':
            dates = stripped[3:]
            print_free_bedrooms(bedroom_list,reservation_list,dates)
        elif cmd == 'LO':
            dates = stripped[3:]
            print_occupied_bedrooms(bedroom_list, reservation_list, dates)
        elif cmd == 'PL':
            print(stripped[3:])
        else:
            print ('Error: Unknown command')
            sys.exit(1)


print ("\n### Stage V ###\n")
stage5()
'''
#################################################################
# Stage VI
#################################################################  

def stage6():
    bedroom_list=[]
    reservation_list=[]
    reservation_counter = 0

    #for previous day's data
    choice = input("Read previous day's data? (y/n): ")
    if choice == 'y':
        bedroom_list, reservation_list, reservation_counter = handle_commands(bedroom_list,reservation_list,
                                                                              reservation_counter)

    #for today's data
    print("Reading today's data...")
    bedroom_list, reservation_list, reservation_counter = handle_commands(bedroom_list,reservation_list,
                                                                              reservation_counter)

    #for write file
    write_string = generate_file_content(bedroom_list,reservation_list)
    outfile = input("File to write today's data to: ")
    f = open(outfile, 'w')
    f.write(write_string)
    f.close()

print ("\n### Stage VI ###\n")
stage6()
