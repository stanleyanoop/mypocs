export class WorklistData {
    public worklistId: number;
    public name: string;
    public shortRequest: string;
    public dateRequested: string;
    public dateResolved: string;
    public requestStatus: {
        statusId: number,
        status: string,
        statusDescription: string
    };
    public user: {
        userId: number,
        firstName: string,
        lastName: string,
        userName: string,
        passWord: string
    };
constructor (
        worklistId: number,
        name: string,
        shortRequest: string,
        dateRequested: string,
        dateResolved: string,
        requestStatus: {
            statusId: number,
            status: string,
            statusDescription: string
        },
        user: {
            userId: number,
            firstName: string,
            lastName: string,
            userName: string,
            passWord: string
        }
    ){
        this.worklistId = worklistId;
        this.name = name;
        this.shortRequest = shortRequest;
        this .dateRequested = dateRequested;
        this.dateResolved = dateResolved;
        this.requestStatus =requestStatus;
        this.user = user;
    }
}