import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PetViewComponent } from './pet-view.component';

describe('PetViewComponent', () => {
  let component: PetViewComponent;
  let fixture: ComponentFixture<PetViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PetViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PetViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
