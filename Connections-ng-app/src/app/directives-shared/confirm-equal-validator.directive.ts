import { Validator, NG_VALIDATORS, AbstractControl } from '@angular/forms';
import { Directive, Input } from '@angular/core';


@Directive({
    selector:'[validatePassword]',
    providers: [{
        provide:NG_VALIDATORS,
        useExisting:ConfirmEqualValidatorDirective,
        multi:true
    }]
})
export class ConfirmEqualValidatorDirective implements Validator{

    @Input()
    validatePassword:string;

validate(control:AbstractControl):{[key:string]:any}|null{
    const controlToCompare = control.parent.get(this.validatePassword);
    if(controlToCompare && controlToCompare.value!==control.value){
        return {'notEqual':true};
    }
    return null;
}

}

@Directive({
    selector:'[passwordStrength]',
    providers: [{
        provide:NG_VALIDATORS,
        useExisting:PasswordValidatorDirective,
        multi:true
    }]
})
export class PasswordValidatorDirective implements Validator{

validate(control:AbstractControl):{[key:string]:any}|null{
    //const controlToCompare = control.parent.get(this.passwordStrength);
    const Regex_exp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;
    if(Regex_exp.test(control.value)){
        return null;
    }
    return {'invalidp':true};
}

}