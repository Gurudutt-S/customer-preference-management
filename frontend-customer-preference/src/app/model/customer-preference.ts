export interface Customer {
    id:number;
    custId: number;
    name: string;
    phone: number;
    email: string;
    preferedContact: string;
    workAddress: string;
    homeAddress: string;
    preferedAddress: string;
    deliveryTimings: string;
    offerUpdates: boolean;
    availableOnSunday: boolean;
    created: Date;
    createdBy: string;
    updated: string;
    updatedBy: string;
    isActive: boolean;
}