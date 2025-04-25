export class AppHelper {
    // isLoginSuccessful(userName: string, password: string): boolean {
        
    //     if (userName == '' || password == '') {
    //         return false;
    //     } else {
    //         return true;
    //     }
    // }

    isLoginSuccessful = (userName: string, password: string): boolean => {
        if (userName == '' || password == '') {
            return false;
        } else {
            return true;
        }     
    }
}