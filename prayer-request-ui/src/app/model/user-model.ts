export class UserData {
        public userId: number;
        public firstName: string;
        public lastName: string;
        public userName: string;
        public passWord: string;

        constructor (
            userId: number,
            firstName: string,
            lastName: string,
            userName: string,
            passWord: string
        ){
            this.userId =  userId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.userName = userName;
            this.passWord = passWord;
        }
}