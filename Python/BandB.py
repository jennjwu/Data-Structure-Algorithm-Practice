import sys
import datetime

STAGE1_FILE_IN = "BandB_1.txt"
STAGE2_FILE_IN = "BandB_2.txt"
STAGE3_FILE_IN = "BandB_3.txt"
STAGE4_FILE_IN = "BandB_4.txt"
STAGE5_FILE_IN = "BandB_5.txt"

#################################################################
# Utility functions
#################################################################

def add_bedroom(BL:'list of bedrooms', room_num:int)-> 'list of bedrooms':
    '''Return a list of bedrooms
    '''
    if room_num in BL:
        print("Sorry, can't add room %d again; it's already on the list." % (room_num))
        return BL
    else:
        BL.append(room_num)
        return BL

def delete_bedroom(BL:'list of bedrooms', RL: 'list of reservations',room_num:int) ->('list of bedrooms','list of reservations'):
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

def make_reservation(BL:'list of bedrooms', RL:'list of reservations', reserve_num:int,input_str:str) -> ('list of reservations','reserve_num'):
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
    for room in BL:
        print (room)

def print_reservations(RL:'list of reservations')-> None:
    print("Number of reservations:  %d" % (len(RL)))
    print("No. Rm. Arrive     Depart     Guest")
    print('-'*50)
    for rooms in RL:
        print('{:3d} {:3d} {:10s} {:10s} {:20s}'.format(rooms["no"], rooms["room_num"],
                                                        rooms["arrive"].strftime('%m/%d/%Y'),
                                                        rooms["depart"].strftime('%m/%d/%Y'),
                                                        rooms["guest"]))

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
  
#################################################################
# Stage V
#################################################################      

#def stage5():    



#print ("\n### Stage V ###\n")
#stage5():    

#################################################################
# Stage VI
#################################################################  

#def stage6():     




#print ("\n### Stage VI ###\n")
#stage6():
